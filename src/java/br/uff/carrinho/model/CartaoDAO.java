/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JP
 */
public class CartaoDAO implements DAO{
    
    private Connection conn;

    public CartaoDAO() {
        this.conn = new FabricaConexoes().getConnection();
    }
    
    @Override
    public void fechaConexao() throws SQLException{
        conn.close();
    }

    @Override
    public int cria(Object obj) {
        try {
            Cartao c = (Cartao) obj;
            String sql = "INSERT INTO cartao "
                    + "(numero, validade, titular, ccv, bandeira) "
                    + "values (?, ?, ?, ?, ?)";
            
            PreparedStatement stmt = this.conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, c.getNumero());
            stmt.setString(2, c.getValidade());
            stmt.setString(3, c.getTitular());
            stmt.setString(4, c.getCcv());
            stmt.setString(5, c.getBandeira());
            
            int generatedKey = stmt.executeUpdate();
            stmt.close();
            fechaConexao();
            
            return generatedKey;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object busca(int id) {
        try {
            String sql = "SELECT * FROM cartao "
                    + "WHERE idCartao = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            Cartao cartao = null;
            if (rs.next()){
                cartao = new Cartao(
                        rs.getInt("idCartao"), 
                        rs.getString("numero"), 
                        rs.getString("validade"), 
                        rs.getString("titular"), 
                        rs.getString("ccv"), 
                        rs.getString("bandeira"));
            }
            rs.close();
            stmt.close();
            fechaConexao();
            
            return cartao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void altera(Object obj) {
        try{
            Cartao c = (Cartao) obj;
            String sql = "UPDATE cartao "
                    + "SET numero = ?, validade = ?, titular = ?, ccv = ?, bandeira = ? "
                    + "WHERE idCartao = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, c.getNumero());
            stmt.setString(2, c.getValidade());
            stmt.setString(3, c.getTitular());
            stmt.setString(4, c.getCcv());
            stmt.setInt(5, c.getIdCartao());
            stmt.execute();
            
            stmt.close();
            fechaConexao();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void deleta(Object obj) {
        try {
            Cartao c = (Cartao) obj;
            
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM cartao WHERE idCartao = ?");
            stmt.setInt(1, c.getIdCartao());
            stmt.execute();
            
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }  
    }
    
}
