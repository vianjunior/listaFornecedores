/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devjunior.listaempresas.data;

import com.devjunior.listaempresas.infra.ConexaoPostgresJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author Junior
 */
public class FornecedorDAO {
    
    Connection conn;
    
    String sqlBusca = "SELECT * FROM public.\"FORNECEDORES\" ORDER BY \"IDFORNECEDOR\"";
    String sqlInsere = "INSERT INTO public.\"FORNECEDORES\"(\"RAZAOSOCIAL\", \"EMAIL\", \"CNPJ\", \"OBS\") VALUES (?, ?, ?, ?)";
    String sqlAtualiza = "UPDATE public.\"FORNECEDORES\" SET \"RAZAOSOCIAL\"=?, \"EMAIL\"=?, \"CNPJ\"=?, \"OBS\"=? WHERE \"IDFORNECEDOR\"=?";
    String sqlDeleta = "DELETE FROM public.\"FORNECEDORES\" WHERE \"IDFORNECEDOR\"=?";
    
    private PreparedStatement selecionarRegistros;
    private PreparedStatement inserirRegistros;
    private PreparedStatement atualizarRegistros;
    private PreparedStatement deletarRegistros;
    
    public FornecedorDAO() throws SQLException {
    
        ConexaoPostgresJDBC conexao = new ConexaoPostgresJDBC();
        
        conn = conexao.getConexao();
        
        selecionarRegistros = conn.prepareStatement(sqlBusca);
        inserirRegistros = conn.prepareStatement(sqlInsere);
        atualizarRegistros = conn.prepareStatement(sqlAtualiza);
        deletarRegistros = conn.prepareStatement(sqlDeleta);

    }
    
    public ArrayList selecionarRegistros() throws SQLException {
    
        ArrayList listaFornecedores = new ArrayList();
        
        ResultSet rs = selecionarRegistros.executeQuery();
        
        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt(1));
            fornecedor.setRazaoSocial(rs.getString(2));
            fornecedor.setEmail(rs.getString(3));
            fornecedor.setCnpj(rs.getString(4));
            fornecedor.setObs(rs.getString(5));
            
            listaFornecedores.add(fornecedor);
        }
        
        return listaFornecedores;
    }
    
    public int inserirRegistros(String fornecedor) throws SQLException {
        
        int resultado;
        
        JSONObject jsonObject = new JSONObject(fornecedor);
        String razaoSocial = jsonObject.getString("razaoSocial");
        String email = jsonObject.getString("email");
        String cnpj = jsonObject.getString("cnpj");
        String obs = jsonObject.getString("obs");
        
        inserirRegistros.setString(1, razaoSocial);
        inserirRegistros.setString(2, email);
        inserirRegistros.setString(3, cnpj);
        inserirRegistros.setString(4, obs);
        
        resultado = inserirRegistros.executeUpdate();
        
        return resultado;
    }
    
    public int deletarRegistros(String fornecedor) throws SQLException {
        
        int resultado;
        JSONObject jsonObject = new JSONObject(fornecedor);
        int idFornecedor = jsonObject.getInt("id");
        
        deletarRegistros.setInt(1, idFornecedor);
        
        resultado = deletarRegistros.executeUpdate();
        
        return resultado;
        
    }
    
    public int atualizarRegistros(String fornecedor) throws SQLException {
        
        int resultado;
        JSONObject jsonObject = new JSONObject(fornecedor);
        
        String razaoSocial = jsonObject.getString("razaoSocial");
        String email = jsonObject.getString("email");
        String cnpj = jsonObject.getString("cnpj");
        String obs = jsonObject.getString("obs");
        int idFornecedor = jsonObject.getInt("id");
        
        atualizarRegistros.setString(1, razaoSocial);
        atualizarRegistros.setString(2, email);
        atualizarRegistros.setString(3, cnpj);
        atualizarRegistros.setString(4, obs);
        atualizarRegistros.setInt(5, idFornecedor);
        
        
        resultado = atualizarRegistros.executeUpdate();
        
        return resultado;
        
    }
    
}
