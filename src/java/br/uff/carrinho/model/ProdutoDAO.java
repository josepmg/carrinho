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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JP
 */
public class ProdutoDAO implements DAO{
    
    private Connection conn;

    public ProdutoDAO() {
        this.conn = new FabricaConexoes().getConnection();
    }
    
    @Override
    public void fechaConexao() throws SQLException{
        conn.close();
    }

    @Override
    public int cria(Object obj) {
        try {
            Produto p = (Produto) obj;
            String sql = "INSERT INTO produto (nome, descricao, preco, imagePath) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getPreco());
            stmt.setString(4, p.getImagePath());
            int generatedKey = stmt.executeUpdate();
            
            stmt.close();
            fechaConexao();
            return generatedKey;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object busca(int id) {
        try {
            String sql = "SELECT * FROM produto "
                    + "WHERE idProduto = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            Produto p = null;
            if (rs.next()){
                p = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("descricao"), rs.getFloat("preco"), rs.getString("imagePath"));
            }
            
            rs.close();
            stmt.close();
            fechaConexao();
            
            return p;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void altera(Object obj) {
        try {
            Produto p = (Produto) obj;
            String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, imagePath = ? "
                    + "WHERE idProduto = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setFloat(3, p.getPreco());
            stmt.setString(4, p.getImagePath());
            stmt.setInt(5, p.getIdProduto());
            stmt.execute();
            
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleta(Object obj) {
        try {
            Produto p = (Produto) obj;
            
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            stmt.setInt(1, p.getIdProduto());
            stmt.execute();
            
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Produto> listaTodos(){
        try {
            String sql = "SELECT * FROM produto";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();    
            List<Produto> listaProdutos = new ArrayList<>();
            while(rs.next()){
                listaProdutos.add(
                    new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getString("descricao"), rs.getFloat("preco"), rs.getString("imagePath"))
                );
            }
            
            rs.close();
            stmt.close();
            fechaConexao();
            return listaProdutos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
