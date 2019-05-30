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
    
    private String numero;
    private String validade;
    private String titular;
    private String cvv;
    private String bandeira;

    public Cartao() {
    }

    public Cartao(String numero, String validade, String titular, String cvv, String bandeira) {
        this.numero = numero;
        this.validade = validade;
        this.titular = titular;
        this.cvv = cvv;
        this.bandeira = bandeira;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
    
    
    
}
