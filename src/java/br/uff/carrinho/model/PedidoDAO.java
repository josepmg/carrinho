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
public class PedidoDAO implements DAO{
    
    private Connection conn;

    public PedidoDAO() {
        this.conn = new FabricaConexoes().getConnection();
    }
    
    @Override
    public void fechaConexao() throws SQLException{
        conn.close();
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    @Override
    public int cria(Object obj) {
        try {
            Pedido p = (Pedido) obj;
            String sql = "INSERT INTO pedido (idUsuario, idCartao, valorTotal, dataCompra, enderecoEntrega, estado) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, (p.getCliente()).getIdUsuario());
            stmt.setInt(2, (p.getCartao()).getIdCartao());
            stmt.setFloat(3, p.getValorTotal());
            stmt.setString(4, p.getDataCompra());
            stmt.setString(5, p.getEnderecoEntrega());
            stmt.setString(6, Pedido.ESTADO_REALIZADO);
            // Executa o comando SQL e guarda o ID do registro criado no BD
            int pedidoKey = stmt.executeUpdate();
            System.out.println("Id inserido: " + pedidoKey);
            
            
            int itemKey;
            // Instancia um objeto DAO para acessar a tabela itemPedidoDAO
            ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
            // Para cada item do pedido, cria um registro no BD e guarda o ID
            // Além disso, deve-se criar um registro da tabela itemPedido para cada item do pedido
            for (Item i : p.getItensPedido()){
                // Cria um registro na tabela Item com os itens do pedido
                itemKey = (new ItemDAO()).cria(i);
                // Cria um registro na tabela itemPedido
                itemPedidoDAO.cria(pedidoKey, itemKey);
            }
            
            stmt.close();
            fechaConexao();
            return pedidoKey;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    @Override
    public Object busca(int id) {
        try {
            List<Item> listaItens = (List<Item>) (new ItemPedidoDAO()).buscaPorPedido(id);
            String sql = "SELECT * FROM pedido WHERE idPedido = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Pedido pedido = null;
            if(rs.next()){
                pedido = new Pedido(rs.getInt("idPedido"), 
                        listaItens,
                        rs.getFloat("valorTotal"),
                        (Usuario)(new UsuarioDAO()).busca(rs.getInt("idUsuario")),
                        rs.getString("enderecoEntrega"),
                        (Cartao)(new CartaoDAO()).busca(rs.getInt("idCartao")),
                        rs.getString("dataCompra"),
                        rs.getString("estado"));
            }
            
            rs.close();
            stmt.close();
            fechaConexao();
            return pedido;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    @Override
    public void altera(Object obj) {
        try {
            Pedido p = (Pedido) obj;
            String sql = "UPDATE pedido SET estado = ? "
                    + "WHERE idPedido = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, p.getEstado());
            stmt.setInt(2, p.getIdPedido());
            stmt.execute();
            
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* ------ */
    /* TESTAR */
    /* ------ */
    @Override
    public void deleta(Object obj) {
        try {
            Pedido p = (Pedido) obj;
            
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM pedido WHERE idPedido = ?");
            stmt.setInt(1, p.getIdPedido());
            stmt.execute();
            
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object listaPorUsuario(Usuario u) {
        try {
            String sql = "SELECT * FROM pedido WHERE idUsuario = ?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, u.getIdUsuario());
            ResultSet rs = stmt.executeQuery();
            
            List<Pedido> listaPedidos = new ArrayList<>();
            if(rs.next()){
                listaPedidos.add(
                        new Pedido(
                                rs.getInt("idPedido"), 
                                (List<Item>) (new ItemPedidoDAO()).buscaPorPedido(rs.getInt("idPedido")),
                                rs.getFloat("valorTotal"),
                                (Usuario)(new UsuarioDAO()).busca(rs.getInt("idUsuario")),
                                rs.getString("enderecoEntrega"),
                                (Cartao)(new CartaoDAO()).busca(rs.getInt("idCartao")),
                                rs.getString("dataCompra"),
                                rs.getString("estado")
                        ));
            }
            
            rs.close();
            stmt.close();
            fechaConexao();
            return listaPedidos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
