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

    public void cria(int idPedido, int idItem) {
        try {
            String sql = "INSERT INTO itemPedido (idPedido, idItem) "
                    + "VALUES (?, ?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idPedido);
            stmt.setInt(2, idItem);
            int generatedKey = stmt.executeUpdate();
            
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Object buscaPorPedido(int idPedido) {
        try {
            String sql = "SELECT * FROM itemPedido "
                    + "WHERE idPedido = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idPedido);
            
            ResultSet rs = stmt.executeQuery();
            // Cria uma lista de Itens
            List<Item> listaItem = new ArrayList<>();
            // Cria um DAO para buscar os Itens do ResultSet
            ItemDAO itemDAO = new ItemDAO();
            // Enquanto houver itens no ResultSet
            while (rs.next()){
                // Adiciona o Item da compra na lista de Itens
                listaItem.add(
                        // Utiliza o DAO para buscar o item por id
                        (Item) itemDAO.busca(rs.getInt("idItem"))
                );
            }
            // Encerra o resultSet
            rs.close();
            // Fecha o PreparedStatment
            stmt.close();
            // Fecha a conexão com o BD
            fechaConexao();
            // Retorna  alista de itens do pedido
            return listaItem;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Object buscaPorItem(int idItem) {
        try {
            String sql = "SELECT * FROM itemPedido "
                    + "WHERE idItem = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, idItem);
            
            ResultSet rs = stmt.executeQuery();
            // Cria uma lista de Pedidos
            List<Pedido> listaPedidos = new ArrayList<>();
            // Cria um DAO para buscar os Pedidos do ResultSet
            PedidoDAO pedidoDAO = new PedidoDAO();
            // Enquanto houver itens no ResultSet
            while (rs.next()){
                // Adiciona, na lista, o Pedido em que o Item figura
                listaPedidos.add(
                        // Utiliza o DAO para buscar o pedido por id
                        (Pedido) pedidoDAO.busca(rs.getInt("idPedido"))
                );
            }
            // Encerra o resultSet
            rs.close();
            // Fecha o PreparedStatment
            stmt.close();
            // Fecha a conexão com o BD
            fechaConexao();
            // Retorna  a lista de pedidos com o Item
            return listaPedidos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
