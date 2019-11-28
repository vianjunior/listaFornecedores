/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devjunior.listaempresas.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior
 */
public class ConexaoPostgresJDBC {
    private Connection conexao;
    
    public  ConexaoPostgresJDBC(){
        try{
            String url ="jdbc:postgresql://localhost:5432/postgres";
            String usuario = "postgres";
            String senha = "postgres";

            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar com o banco de dados");
        }
    }
    
     public Connection getConexao(){
        return conexao;
    } 

    
}
