/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.readsped.model;

/**
 *
 * @author andreimenezes
 */
public class Arquivo {
    
    private String nomeClienteArquivo; 
    private String cnpjClienteArquivo; 
    private String dataArquivo;
    
    

    public String getNomeClienteArquivo() {
        return nomeClienteArquivo;
    }

    public void setNomeClienteArquivo(String nomeClienteArquivo) {
        this.nomeClienteArquivo = nomeClienteArquivo;
    }

    public String getCnpjClienteArquivo() {
        return cnpjClienteArquivo;
    }

    public void setCnpjClienteArquivo(String cnpjClienteArquivo) {
        this.cnpjClienteArquivo = cnpjClienteArquivo;
    }

    public String getDataArquivo() {
        return dataArquivo;
    }

    public void setDataArquivo(String dataArquivo) {
        this.dataArquivo = dataArquivo;
    }
   
}
