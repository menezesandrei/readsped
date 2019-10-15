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
public enum IndiceSpedContribuicoesEnun {
       
   REGISTRO_0000_TOTAL_CAMPOS(14), 
   REGISTRO_0000_NOME(8), 
   REGISTRO_0000_CNPJ(9), 
   REGISTRO_0000_DATA(6), 
   
   REGISTRO_C170_TOTAL_CAMPOS(38), 
   REGISTRO_C170_CST(25),
   REGISTRO_C170_VALOR(7),
   REGISTRO_C170_CFOP(11),
   REGISTRO_C170_BC(26),
   
   REGISTRO_C175_TOTAL_CAMPOS(18), 
   REGISTRO_C175_CST(5),
   REGISTRO_C175_VALOR(3),
   REGISTRO_C175_CFOP(2),
   REGISTRO_C175_BC(6),
   
   REGISTRO_C181_TOTAL_CAMPOS(11), 
   REGISTRO_C181_CST(2),
   REGISTRO_C181_VALOR(4),
   REGISTRO_C181_CFOP(3),
   REGISTRO_C181_BC(6),
   
   REGISTRO_481_TOTAL_CAMPOS(10), 
   REGISTRO_C481_CST(2),
   REGISTRO_C481_VALOR(3),
   REGISTRO_C481_BC(4),
   
   REGISTRO_C491_TOTAL_CAMPOS(11), 
   REGISTRO_C491_CST(3),
   REGISTRO_C491_VALOR(5),
   REGISTRO_C491_BC(6),
   REGISTRO_C491_CFOP(4),
     
   REGISTRO_C810_TOTAL_CAMPOS(13), 
   REGISTRO_C810_CST(5),
   REGISTRO_C810_VALOR(3),
   REGISTRO_C810_BC(6),
   REGISTRO_C810_CFOP(2),
   
   REGISTRO_C870_TOTAL_CAMPOS(14), 
   REGISTRO_C870_CST(6),
   REGISTRO_C870_VALOR(4),
   REGISTRO_C870_BC(7),
   REGISTRO_C870_CFOP(3),
   
   REGISTRO_C501_TOTAL_CAMPOS(8), 
   REGISTRO_C501_VALOR(3),
   REGISTRO_C501_CST(2),
   REGISTRO_C501_BC(5);
    
   
   private final int indice;
   
   
   IndiceSpedContribuicoesEnun(int indice)
   {
    this.indice = indice;
   }
   
   public int getIndice()
   {
     return indice;
   }
}
