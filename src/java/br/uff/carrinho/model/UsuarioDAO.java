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

/**
 *
 * @author JP
 */
public class UsuarioDAO implements DAO{

    private Connection conn;

    public UsuarioDAO() {
        this.conn = new FabricaConexoes().getConnection();
    }
    
    @Override
    public void fechaConexao() throws SQLException{
        conn.close();
    }
    
    @Override
    public int cria(Object obj) {
        Usuario u = (Usuario) obj;
        String sql = "INSERT INTO usuario "
                + "(nomeCompleto, dataNascimento, apelido, email, senha) "
                + "values (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, u.getNomeCompleto());
            stmt.setString(2, u.getDataNascimento());
            stmt.setString(3, u.getApelido());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getSenha());
            int generatedKey = stmt.executeUpdate();
            
            stmt.close();
            fechaConexao();
            return generatedKey;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }      
    }

    @Override
    public Object busca(int id) {
         try {
            // Cria o statment que contém a Query de consulta
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, id);
            // Cria uma varíavel para receber o resultado da Query
            ResultSet rs = stmt.executeQuery();
            
            // Cria usuário encontrado
            Usuario usuario = null;
            // Verifica se houve algum retorno
            if (rs.next()){
                usuario = new Usuario(
                        rs.getInt("idUsuario"), 
                        rs.getString("nomeCompleto"), 
                        rs.getString("dataNascimento"), 
                        rs.getString("apelido"), 
                        rs.getString("email"), 
                        rs.getString("senha"),
                        (Cartao) (new CartaoDAO()).busca(rs.getInt("idCartao"))
                );
            }
            // Encerra o ResultSet
            rs.close();
            // Encerra o Statment
            stmt.close();
            
            fechaConexao();
            // Retorna a lista de Usuários do BD
            return usuario;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        } 
    }

    @Override
    public void altera(Object obj) {  
        try {
            Usuario u = (Usuario) obj;
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE usuario "
                    + "set nomeCompleto = ?, "
                    + "dataNascimento = ?, "
                    + "apelido = ?, "
                    + "email = ?, "
                    + "senha = ? "
                    + "WHERE idUsuario = ?");
            stmt.setString(1, u.getNomeCompleto());
            stmt.setString(2, u.getDataNascimento());
            stmt.setString(3, u.getApelido());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getSenha());
            stmt.setInt(6, u.getIdUsuario());
            stmt.execute();
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleta(Object obj) {
        try {
            Usuario u = (Usuario) obj;
            
            // Remover todas compras //
            
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, u.getIdUsuario());
            stmt.execute();
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }   
    }
    
    public Usuario buscaLogin(String email, String senha){
        try {
            // Cria o statment que contém a Query de consulta
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM usuario WHERE "
                    + "	email = ? and "
                    + "senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            // Cria uma varíavel para receber o resultado da Query
            ResultSet rs = stmt.executeQuery();
            
            // Cria usuário encontrado
            Usuario usuario = null;
            // Verifica se houve algum retorno
            if (rs.next()){
                usuario = new Usuario(
                        rs.getInt("idUsuario"), 
                        rs.getString("nomeCompleto"), 
                        rs.getString("dataNascimento"), 
                        rs.getString("apelido"), 
                        rs.getString("email"), 
                        rs.getString("senha"),
                        (Cartao) (new CartaoDAO()).busca(rs.getInt("idCartao"))
                );
            }
            // Encerra o ResultSet
            rs.close();
            // Encerra o Statment
            stmt.close();
            
            fechaConexao();
            // Retorna a lista de Usuários do BD
            return usuario;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        } 
    }
    
    public Usuario buscaPorEmail(String email){
        try {
            // Cria o statment que contém a Query de consulta
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            stmt.setString(1, email);
            // Cria uma varíavel para receber o resultado da Query
            ResultSet rs = stmt.executeQuery();
            
            // Cria usuário encontrado
            Usuario usuario = null;
            // Verifica se houve algum retorno
            if (rs.next()){
                usuario = new Usuario(
                        rs.getInt("idUsuario"), 
                        rs.getString("nomeCompleto"), 
                        rs.getString("dataNascimento"), 
                        rs.getString("apelido"), 
                        rs.getString("email"), 
                        rs.getString("senha"),
                        (Cartao) (new CartaoDAO()).busca(rs.getInt("idCartao"))
                );
            }
            // Encerra o ResultSet
            rs.close();
            // Encerra o Statment
            stmt.close();
            
            fechaConexao();
            // Retorna usuario
            return usuario;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        } 
    }
    
    public void alteraSenha(Object obj){
        try {
            Usuario u = (Usuario) obj;
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE usuario SET "
                    + "senha = ? "
                    + "WHERE idUsuario = ?");
            stmt.setString(1, u.getSenha());
            stmt.setInt(2, (u.getIdUsuario()));
            stmt.execute();
            stmt.close();
            fechaConexao();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
}
