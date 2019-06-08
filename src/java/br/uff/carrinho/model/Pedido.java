/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.carrinho.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JP
 */
public class Pedido {
    
    public static String ESTADO_REALIZADO = "Realizado";
    public static String ESTADO_APROVADO = "Aprovado";
    public static String ESTADO_ENTREGUE = "Entregue";
    public static String ESTADO_NEGADO = "Negado";    
    
    
    private int idPedido;
    private List<Item> itensPedido = new ArrayList<>();;
    private float valorTotal = 0;
    private Usuario cliente;
    private String enderecoEntrega;
    private Cartao cartao;
    private long dataCompra;
    private String estado;

    public Pedido() {
    }

    public Pedido(int idPedido, List<Item> itensPedido, float valorTotal, Usuario cliente, String enderecoEntrega, Cartao cartao, long dataCompra, String estado) {
        this.idPedido = idPedido;
        this.itensPedido = itensPedido;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.cartao = cartao;
        this.dataCompra = dataCompra;
        this.estado = estado;
    }
    
    public void adicionaProduto(Produto p){
        this.itensPedido.add(
                new Item(p, 1, p.getPreco())
        
        );
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    public List<Item> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<Item> itensPedido) {
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

    public long getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(long dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void calculaValorTotal(){
        this.valorTotal = 0;
        for (Item i : itensPedido){
            this.valorTotal+= i.getQuantidade()*i.getPreco();
        }
    }
    
}
