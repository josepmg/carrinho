/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JP
 */
public class ItemPedidoDAO{

    private Connection conn;

    public ItemPedidoDAO() {
        this.conn = new FabricaConexoes().getConnection();
    }
    
    public void fechaConexao() throws SQLException{
        conn.close();
    }

    public int cria(Pedido p, Item i) {
        try {
            String sql = "INSERT INTO itemPedido (idPedido, idItem) "
                    + "VALUES (?, ?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, p.getIdPedido());
            stmt.setInt(2, i.getIdItem());
            int generatedKey = stmt.executeUpdate();
            
            stmt.close();
            fechaConexao();
            return generatedKey;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Object busca(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object busca(Item i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleta(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
