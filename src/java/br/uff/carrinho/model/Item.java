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
public class Item {
    
    private int idItem;
    private Produto produto;
    private int quantidade;
    private float preco;

    public Item() {
    }

    public Item(Produto produto, int quantidade, float preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Item(int idItem, Produto produto, int quantidade, float preco) {
        this.idItem = idItem;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    
}
