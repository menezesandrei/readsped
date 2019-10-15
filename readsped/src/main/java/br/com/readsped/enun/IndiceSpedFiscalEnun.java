/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.readsped.enun;

/**
 *
 * @author andreimenezes
 */
public enum IndiceSpedFiscalEnun {
   
   REGISTRO_0000_TOTAL_CAMPOS(15), 
   REGISTRO_0000_NOME(6), 
   REGISTRO_0000_CNPJ(7), 
   REGISTRO_0000_DATA(4), 
   REGISTRO_C170_TOTAL_CAMPOS(38), 
   REGISTRO_C170_CST(25),
   REGISTRO_C170_VALOR(7),
   REGISTRO_C170_CFOP(11),
   REGISTRO_C170_BC(26),
   
   REGISTRO_C190_TOTAL_CAMPOS(12), 
   REGISTRO_C190_CST(2),
   REGISTRO_C190_VALOR(5),
   REGISTRO_C190_CFOP(3),
   REGISTRO_C190_BC(6),
   
   REGISTRO_C470_TOTAL_CAMPOS(11), 
   REGISTRO_C470_CST(7),
   REGISTRO_C470_VALOR(6),
   REGISTRO_C470_CFOP(8),
   
   REGISTRO_490_TOTAL_CAMPOS(8), 
   REGISTRO_C490_CST(2),
   REGISTRO_C490_VALOR(5),
   REGISTRO_C490_BC(6),
   REGISTRO_C490_CFOP(3),
   
   REGISTRO_C800_TOTAL_CAMPOS(17), 
   REGISTRO_C800_CST(26),
   REGISTRO_C800_VALOR(26),
   REGISTRO_C800_BC(26),
   
   REGISTRO_C850_TOTAL_CAMPOS(8), 
   REGISTRO_C850_CST(2),
   REGISTRO_C850_VALOR(5),
   REGISTRO_C850_BC(6),
   REGISTRO_C850_CFOP(3),
   
   REGISTRO_C500_TOTAL_CAMPOS(27), 
   REGISTRO_C500_VALOR(13);
   
   
   private final int indice;
   
   
   IndiceSpedFiscalEnun(int indice)
   {
    this.indice = indice;
   }
   
   public int getIndice()
   {
     return indice;
   }
}
