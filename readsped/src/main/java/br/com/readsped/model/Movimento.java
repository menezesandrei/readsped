/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.readsped.model;

import java.math.BigDecimal;

/**
 *
 * @author andreimenezes
 */
public class Movimento {
    
    private String cst;
    private String cfop;
    private BigDecimal valor;
    private BigDecimal valorBc;
    
    

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getCfop() {
        return cfop;
    }

    public void setCfop(String cfop) {
        this.cfop = cfop;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorBc() {
        return valorBc;
    }

    public void setValorBc(BigDecimal valorBc) {
        this.valorBc = valorBc;
    }

}
