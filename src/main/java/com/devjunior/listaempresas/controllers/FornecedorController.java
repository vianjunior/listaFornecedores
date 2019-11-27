/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devjunior.listaempresas.controllers;

import com.devjunior.listaempresas.data.Fornecedor;
import com.devjunior.listaempresas.data.Status;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Junior
 */
@Path("fornecedores")
public class FornecedorController {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lista")
    public List<Fornecedor> listFornecedores(){
        Fornecedor f1 = new Fornecedor();
        f1.setId(1);
        f1.setRazaoSocial("Empresa Teste Junior");
        f1.setEmail("email@email.com");
        f1.setCnpj("123456789101101");
        f1.setObs("Deu boa");
        f1.setStatus(Status.ATIVO);
        
        Fornecedor f2 = new Fornecedor();
        f2.setId(2);
        f2.setRazaoSocial("Empresa Teste Bruna");
        f2.setEmail("email@email.com");
        f2.setCnpj("123456789101101");
        f2.setObs("Deu boa");
        f2.setStatus(Status.ATIVO);
        
        Fornecedor f3 = new Fornecedor();
        f3.setId(3);
        f3.setRazaoSocial("Empresa Teste Marcelo");
        f3.setEmail("email@email.com");
        f3.setCnpj("123456789101101");
        f3.setObs("Deu boa");
        f3.setStatus(Status.INATIVO);
        
        List<Fornecedor> fornecedores = new ArrayList<>();
        fornecedores.add(f1);
        fornecedores.add(f2);
        fornecedores.add(f3);
        
        return fornecedores;
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lista/{id}")
    public Fornecedor getFornecedor(@PathParam("id") long id){
        Fornecedor f1 = new Fornecedor();
        f1.setId(id);
        f1.setRazaoSocial("Empresa Teste " + id);
        f1.setEmail("email@email.com2 " + id);
        f1.setCnpj("123456789101101 " + id);
        f1.setObs("Deu boa2 " + id);
        f1.setStatus(Status.ATIVO);
        
        return f1;
    
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cadastra")
    public Response createFornecedor(Fornecedor fornecedor) {
        System.out.println(fornecedor.toString());
        return Response.status(Response.Status.OK).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualiza")
    public Response updateFornecedor(Fornecedor fornecedor){
        System.out.println(fornecedor.toString());
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/deleta/{id}")
    public Response deleteFornecedor(@PathParam("id") long id){
        System.out.println("Deletando Fornecedor: " + id);
        return Response.status(Response.Status.OK).build();
    }    
     
}
