/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devjunior.listaempresas;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Junior
 */
@ApplicationPath("rest")
public class listaEmpresas extends ResourceConfig{
    
    public listaEmpresas(){
        packages("com.devjunior.listaempresas.controllers");
    }
    
}
