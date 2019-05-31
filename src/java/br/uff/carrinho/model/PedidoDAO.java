/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JP
 */
public class PedidoDAO implements DAO{
    
    private Connection conn;

    public PedidoDAO() {
        this.conn = new FabricaConexoes().getConnection();
    }
    
    @Override
    public void fechaConexao() throws SQLException{
        conn.close();
    }

    @Override
    public int cria(Object obj) {
        try {
            Pedido p = (Pedido) obj;
            String sql = "INSERT INTO pedido (idUsuario, idCartao, valorTotal, dataCompra, enderecoEntrega) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, (p.getCliente()).getIdUsuario());
            stmt.setInt(2, (p.getCartao()).getIdCartao());
            stmt.setFloat(3, p.getValorTotal());
            stmt.setString(4, p.getDataCompra());
            stmt.setString(5, p.getEnderecoEntrega());
            int generatedKey = stmt.executeUpdate();
            System.out.println("Id inserido: " + generatedKey);
            
            int itemKey;
            for (Item i : p.getItensPedido()){
                itemKey = (new ItemDAO()).cria(i);
                
            }
            
            stmt.close();
            fechaConexao();
            return generatedKey;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }

    @Override
    public Object busca(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altera(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleta(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
