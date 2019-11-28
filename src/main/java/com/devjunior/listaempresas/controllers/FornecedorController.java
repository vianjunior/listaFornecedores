/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devjunior.listaempresas.controllers;

import com.devjunior.listaempresas.data.Fornecedor;
import com.devjunior.listaempresas.data.FornecedorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
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
    public ArrayList<Fornecedor> listFornecedores() throws SQLException{
        
        ArrayList fornecedores = new ArrayList();
        FornecedorDAO fd = new FornecedorDAO();
        fornecedores = fd.selecionarRegistros();
        return fornecedores;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cadastra")
    public Response createFornecedor(String fornecedor) throws SQLException {
        try{
            FornecedorDAO fd = new FornecedorDAO();
            int resultado = fd.inserirRegistros(fornecedor);
            return Response.ok(resultado).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualiza")
    public Response updateFornecedor(String fornecedor) throws SQLException{
        FornecedorDAO fd = new FornecedorDAO();
        int resultado = fd.atualizarRegistros(fornecedor);
        return Response.status(Response.Status.OK).build();
    }
    
    @DELETE
    @Path("/deleta")
    public Response deleteFornecedor(String fornecedor) throws SQLException{
        FornecedorDAO fd = new FornecedorDAO();
        int resultado = fd.deletarRegistros(fornecedor);
        return Response.status(Response.Status.OK).build();
    }    
     
}
