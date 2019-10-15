/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.readsped.service;

import br.com.readsped.enun.IndiceSpedContribuicoesEnun;
import br.com.readsped.model.Arquivo;
import br.com.readsped.model.ArquivoContribuicoes;
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
public class ArquivoContribuicoesService {
    
      List<String> registrosEncontradosNoArquivo = new ArrayList<>();
     public  Map<String,Map<String,List<Movimento>>> conteudoContribProcessado = new HashMap<>();

     public Map<String,Map<String,List<Movimento>>> processar(ArquivoService arquivoService)
    {
        Arquivo arquivo;
        Map<String,List<Movimento>> conteudoMovimentacao;
     for(ArquivoContribuicoes contrib : arquivoService.listArquivoContrib)
     { 
        //registro 0000
        arquivo = arquivoService.getCabecalhoArquivo( contrib.getRegistros0000().toString(),IndiceSpedContribuicoesEnun.REGISTRO_0000_NOME.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_0000_CNPJ.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_0000_DATA.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_0000_TOTAL_CAMPOS.getIndice());
         
         
        conteudoMovimentacao = new HashMap<>();
         
         //registro c170
         if(!contrib.getRegistrosC170().toString().equals(null) && !contrib.getRegistrosC170().toString().equals("") ){
        conteudoMovimentacao.put("Registro C170", 
                arquivoService.carregarMovimentos(contrib.getRegistrosC170().toString(),
                IndiceSpedContribuicoesEnun.REGISTRO_C170_CST.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C170_CFOP.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C170_VALOR.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C170_BC.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C170_TOTAL_CAMPOS.getIndice()));
         }
          //registro c175
           if(!contrib.getRegistrosC175().toString().equals(null) && !contrib.getRegistrosC175().toString().equals("") ){
        conteudoMovimentacao.put("Registro C175", 
                arquivoService.carregarMovimentos(contrib.getRegistrosC190().toString(),
                IndiceSpedContribuicoesEnun.REGISTRO_C175_CST.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C175_CFOP.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C175_VALOR.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C175_BC.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C175_TOTAL_CAMPOS.getIndice()));
        
           }
                  //registro c181
            if(!contrib.getRegistrosC181().toString().equals(null) && !contrib.getRegistrosC181().toString().equals("") ){ 
                conteudoMovimentacao.put("Registro C181", 
                arquivoService.carregarMovimentos(contrib.getRegistrosC181().toString(),
                IndiceSpedContribuicoesEnun.REGISTRO_C181_CST.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C181_CFOP.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C181_VALOR.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C181_VALOR.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C181_TOTAL_CAMPOS.getIndice()));
            }
            
                    //registro c481
            if(!contrib.getRegistrosC481().toString().equals(null) && !contrib.getRegistrosC481().toString().equals("") ){   
                conteudoMovimentacao.put("Registro C481", 
                arquivoService.carregarMovimentos(contrib.getRegistrosC481().toString(),
                IndiceSpedContribuicoesEnun.REGISTRO_C481_CST.getIndice(),0,
                IndiceSpedContribuicoesEnun.REGISTRO_C481_VALOR.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C481_VALOR.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_481_TOTAL_CAMPOS.getIndice()));
            }
            
                    //registro c491
            if(!contrib.getRegistrosC491().toString().equals(null) && !contrib.getRegistrosC491().toString().equals("") ){ 
                conteudoMovimentacao.put("Registro C491", 
                arquivoService.carregarMovimentos(contrib.getRegistrosC491().toString(),
                IndiceSpedContribuicoesEnun.REGISTRO_C491_CST.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C491_CFOP.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C491_VALOR.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C491_VALOR.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C491_TOTAL_CAMPOS.getIndice()));
            }
            
                      //registro c810
            if(!contrib.getRegistrosC810().toString().equals(null) && !contrib.getRegistrosC810().toString().equals("") ){ 
                conteudoMovimentacao.put("Registro C810", 
                arquivoService.carregarMovimentos(contrib.getRegistrosC810().toString(),
                IndiceSpedContribuicoesEnun.REGISTRO_C810_CST.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C810_CFOP.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C810_VALOR.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C810_VALOR.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C810_TOTAL_CAMPOS.getIndice()));
            }
            
                        //registro c870
            if(!contrib.getRegistrosC870().toString().equals(null) && !contrib.getRegistrosC870().toString().equals("") ){    
                conteudoMovimentacao.put("Registro C870", 
                arquivoService.carregarMovimentos(contrib.getRegistrosC870().toString(),
                IndiceSpedContribuicoesEnun.REGISTRO_C870_CST.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C870_CFOP.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C870_VALOR.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C870_VALOR.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C870_TOTAL_CAMPOS.getIndice()));
            }
            
                         //registro c501
            if(!contrib.getRegistrosC501().toString().equals(null) && !contrib.getRegistrosC501().toString().equals("") ){  
                conteudoMovimentacao.put("Registro C501", 
                arquivoService.carregarMovimentos(contrib.getRegistrosC501().toString(),
                IndiceSpedContribuicoesEnun.REGISTRO_C501_CST.getIndice(),0,
                IndiceSpedContribuicoesEnun.REGISTRO_C501_VALOR.getIndice(),IndiceSpedContribuicoesEnun.REGISTRO_C501_VALOR.getIndice(),
                IndiceSpedContribuicoesEnun.REGISTRO_C501_TOTAL_CAMPOS.getIndice()));
            }
  
        conteudoContribProcessado.put(arquivo.getNomeClienteArquivo()+"|"+arquivo.getCnpjClienteArquivo()+"|"+arquivo.getDataArquivo(), conteudoMovimentacao);
     }
     
     return conteudoContribProcessado;
    }
         public void criarMapDosRegistros(){
        Map<String,Map<String,Map<String,BigDecimal>>> mapPrincipal = new HashMap<>();
    }
}
