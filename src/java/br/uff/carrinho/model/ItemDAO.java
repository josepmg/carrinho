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
public class ItemDAO implements DAO{
    
    private Connection conn;

    public ItemDAO() {
        this.conn = new FabricaConexoes().getConnection();
    }
    
    @Override
    public void fechaConexao() throws SQLException{
        conn.close();
    }

    @Override
    public int cria(Object obj) {
        try {
            Item i = (Item) obj;
            String sql = "INSERT INTO item (idProduto, quantidade, preco) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, (i.getProduto()).getIdProduto());
            stmt.setInt(2, i.getQuantidade());
            stmt.setFloat(3, (i.getProduto()).getPreco());
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
            String sql = "SELECT * FROM item "
                    + "WHERE idItem = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            
            Item i = null;
            if (rs.next()){
                i = new Item(
                        rs.getInt("idItem"),
                        (Produto) (new ProdutoDAO()).busca(rs.getInt("idProduto")), 
                        rs.getInt("quantidade"),
                        rs.getFloat("preco"));
            }
            
            rs.close();
            stmt.close();
            fechaConexao();
            
            return i;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void altera(Object obj) {
        try {
            Item i = (Item) obj;
            String sql = "UPDATE item SET idProduto = ?, quantidade = ?, preco = ? "
                    + "WHERE idItem = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, (i.getProduto()).getIdProduto());
            stmt.setInt(2, i.getQuantidade());
            stmt.setFloat(3, i.getPreco());
            stmt.setInt(4, i.getIdItem());
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
            Item i = (Item) obj;
            
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM item WHERE idItem = ?");
            stmt.setInt(1, i.getIdItem());
            stmt.execute();
            
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
