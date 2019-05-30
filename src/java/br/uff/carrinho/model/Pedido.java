/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

import java.util.List;

/**
 *
 * @author JP
 */
public class Pedido {
    
    private List<ItemPedido> itensPedido;
    private float valorTotal;
    private Usuario cliente;
    private String enderecoEntrega;
    private Cartao cartao;

    public Pedido() {
    }

    public Pedido(List<ItemPedido> itensPedido, float valorTotal, Usuario cliente, String enderecoEntrega, Cartao cartao) {
        this.itensPedido = itensPedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.cartao = cartao;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    
    
}
