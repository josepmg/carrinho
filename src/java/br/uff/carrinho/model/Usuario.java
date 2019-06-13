/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

public class Usuario {

    private int idUsuario;
    private String nomeCompleto;
    private long dataNascimento;
    private String apelido;
    private String email;
    private String senha;
    private Cartao cartao;

    public Usuario() {
    }

    public Usuario(String nomeCompleto, long dataNascimento, String apelido, String email, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.apelido = apelido;
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(String nomeCompleto, long dataNascimento, String apelido, String email, String senha, Cartao cartao) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.apelido = apelido;
        this.email = email;
        this.senha = senha;
        this.cartao = cartao;
    }
    
    public Usuario(int idUsuario, String nomeCompleto, long dataNascimento, String apelido, String email, String senha, Cartao cartao) {
        this.idUsuario = idUsuario;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.apelido = apelido;
        this.email = email;
        this.senha = senha;
        this.cartao = cartao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public long getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(long dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nomeCompleto + "\n" +
                "Apelido: " + this.apelido + "\n" +
                "Email: " + this.email + "\n" +
                "DataNascimento: " + this.dataNascimento + "\n" +
                "Senha: " + this.senha;
    }
    
    
   
}
