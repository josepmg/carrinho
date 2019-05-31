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
public class Cartao {
    
    private int idCartao;
    private String numero;
    private String validade;
    private String titular;
    private String ccv;
    private String bandeira;

    public Cartao() {
    }

    public Cartao(int idCartao, String numero, String validade, String titular, String ccv, String bandeira) {
        this.idCartao = idCartao;
        this.numero = numero;
        this.validade = validade;
        this.titular = titular;
        this.ccv = ccv;
        this.bandeira = bandeira;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
    
    
    
}
