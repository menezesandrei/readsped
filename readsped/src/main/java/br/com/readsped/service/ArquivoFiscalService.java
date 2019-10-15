/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.readsped.service;
 
import br.com.readsped.enun.IndiceSpedFiscalEnun;
import br.com.readsped.model.Arquivo;
import br.com.readsped.model.ArquivoFiscal;
import br.com.readsped.model.Movimento;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author andreimenezes
 */

@Service
public class ArquivoFiscalService {
    
   List<String> registrosEncontradosNoArquivo = new ArrayList<>();
   public Map<String,Map<String,List<Movimento>>> conteudoFiscalProcessado = new HashMap<>();
    
    public Map<String,Map<String,List<Movimento>>> processar(ArquivoService arquivoService)
    {
        Arquivo arquivo;

        Map<String,List<Movimento>> conteudoMovimentacao;
     for(ArquivoFiscal fiscal : arquivoService.listArquivoFiscal)
     { 
        //registro 0000
        arquivo = arquivoService.getCabecalhoArquivo( fiscal.getRegistro0000().toString(),IndiceSpedFiscalEnun.REGISTRO_0000_NOME.getIndice(),IndiceSpedFiscalEnun.REGISTRO_0000_CNPJ.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_0000_DATA.getIndice(),IndiceSpedFiscalEnun.REGISTRO_0000_TOTAL_CAMPOS.getIndice());
         
         
        conteudoMovimentacao = new HashMap<>();
         
         //registro c170
         if(!fiscal.getRegistrosC170().toString().equals("") && !fiscal.getRegistrosC170().toString().equals(null)){
        conteudoMovimentacao.put("Registro C170", 
                arquivoService.carregarMovimentos(fiscal.getRegistrosC170().toString(),
                IndiceSpedFiscalEnun.REGISTRO_C170_CST.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C170_CFOP.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C170_VALOR.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C170_BC.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C170_TOTAL_CAMPOS.getIndice()));
         }
          //registro c190
           if(!fiscal.getRegistrosC190().toString().equals("") && !fiscal.getRegistrosC190().toString().equals(null)){
        conteudoMovimentacao.put("Registro C190", 
                arquivoService.carregarMovimentos(fiscal.getRegistrosC190().toString(),
                IndiceSpedFiscalEnun.REGISTRO_C190_CST.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C190_CFOP.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C190_VALOR.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C190_BC.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C190_TOTAL_CAMPOS.getIndice()));
        
           }
                  //registro c470
            if(!fiscal.getRegistrosC470().toString().equals("") && !fiscal.getRegistrosC470().toString().equals(null)){ 
        conteudoMovimentacao.put("Registro C470", 
                arquivoService.carregarMovimentos(fiscal.getRegistrosC470().toString(),
                IndiceSpedFiscalEnun.REGISTRO_C470_CST.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C470_CFOP.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C470_VALOR.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C470_VALOR.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C470_TOTAL_CAMPOS.getIndice()));
            }
        
                  //registro c490
                   if(!fiscal.getRegistrosC490().toString().equals("") && !fiscal.getRegistrosC490().toString().equals(null)){
        conteudoMovimentacao.put("Registro C490", 
                arquivoService.carregarMovimentos(fiscal.getRegistrosC490().toString(),
                IndiceSpedFiscalEnun.REGISTRO_C490_CST.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C490_CFOP.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C490_VALOR.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C490_BC.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_490_TOTAL_CAMPOS.getIndice()));
                   }
                  //registro c800
                  /*
                   if(!fiscal.getRegistrosC800().toString().equals("")){
        conteudoMovimentacao.put("Registro C800", 
                arquivoService.carregarMovimentos(fiscal.getRegistrosC800().toString(),
                IndiceSpedFiscalEnun.REGISTRO_C800_CST.getIndice(),0,
                IndiceSpedFiscalEnun.REGISTRO_C800_VALOR.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C800_BC.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C800_TOTAL_CAMPOS.getIndice()));
                   }*/
                  //registro c850
                  
                   if(!fiscal.getRegistrosC850().toString().equals("") && !fiscal.getRegistrosC850().toString().equals(null)){
        conteudoMovimentacao.put("Registro C850", 
                arquivoService.carregarMovimentos(fiscal.getRegistrosC850().toString(),
                IndiceSpedFiscalEnun.REGISTRO_C850_CST.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C850_CFOP.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C850_VALOR.getIndice(),IndiceSpedFiscalEnun.REGISTRO_C850_BC.getIndice(),
                IndiceSpedFiscalEnun.REGISTRO_C850_TOTAL_CAMPOS.getIndice()));
                   }
                  //registro c500
                   if(!fiscal.getRegistrosC500().toString().equals("") && !fiscal.getRegistrosC500().toString().equals(null)){
        conteudoMovimentacao.put("Registro C500", 
                arquivoService.carregarMovimentos(fiscal.getRegistrosC500().toString(),
                0,0,IndiceSpedFiscalEnun.REGISTRO_C500_VALOR.getIndice(),0,
                IndiceSpedFiscalEnun.REGISTRO_C500_TOTAL_CAMPOS.getIndice()));
                   }
        conteudoFiscalProcessado.put(arquivo.getNomeClienteArquivo()+"|"+arquivo.getCnpjClienteArquivo()+"|"+arquivo.getDataArquivo(), conteudoMovimentacao);
        
     }
     return conteudoFiscalProcessado;
    }
   
    public void criarMapDosRegistros(){
        Map<String,Map<String,Map<String,BigDecimal>>> mapPrincipal = new HashMap<>();
    }

}
