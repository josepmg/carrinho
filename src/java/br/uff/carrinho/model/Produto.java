/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

/**
 *
 * @author JP
 */
public class Produto {
    
    private int idProduto;
    private String nome;
    private String descicao;
    private float preco;
    private String imagePath;

    public Produto() {
    }

    public Produto(int idProduto, String nome, String descicao, float preco, String imagePath) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descicao = descicao;
        this.preco = preco;
        this.imagePath = imagePath;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
    
}
