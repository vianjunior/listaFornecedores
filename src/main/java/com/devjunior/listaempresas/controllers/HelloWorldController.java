/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devjunior.listaempresas.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Junior
 */
@Path("HelloWorld")
public class HelloWorldController {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMensagem(@QueryParam("usuario") String usuario){
        return "Bem Vindo " + usuario;
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("usuarios/{id}")
    public String getUsuario(@PathParam("id") long id){
        return "Recuperando usuario com ID " + id;
    }
    
}
