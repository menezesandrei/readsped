package br.com.readsped.controller;

import br.com.readsped.model.Arquivo;
import br.com.readsped.model.Movimento;
import br.com.readsped.service.ArquivoContribuicoesService;
import br.com.readsped.service.ArquivoFiscalService;
import br.com.readsped.service.ArquivoService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ArquivoController {

    @Autowired
    ArquivoService arquivoService;
    
    @Autowired
    ArquivoFiscalService arquivoFiscalService;
    
    @Autowired
    ArquivoContribuicoesService arquivoContribService;
    
    @RequestMapping(value = "/home/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadArquivo (@RequestParam("uploadfile") MultipartFile[] uploadfiles) {
        
        try{
            if(uploadfiles != null && uploadfiles[0].getBytes().length > 0){ 
               
               arquivoService.lerArquivos(uploadfiles);
               System.gc();
            }else{
              return new ResponseEntity<String>(new String("Nenhum Arquivo encontrado"), HttpStatus.OK);
            }
            
            return new ResponseEntity<String>(new String( uploadfiles.length+" arquivos encontrados"), HttpStatus.OK);
        
        }catch(IOException e)
        {
        return new ResponseEntity<String>(new String("Nenhum Arquivo encontrado"), HttpStatus.OK);
        }
        
    }
    
    
     @RequestMapping(value = "/fiscal/processar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Map<String,Map<String,List<Movimento>>>> processaArquivosFiscais (@RequestParam("process") String fiscal) {
         Map<String,Map<String,List<Movimento>>> movimentos = new HashMap<>();
        if(arquivoFiscalService.conteudoFiscalProcessado.size() > 0){
         movimentos = arquivoFiscalService.conteudoFiscalProcessado;
        } else{
          movimentos = arquivoFiscalService.processar(arquivoService);
        }
        return new ResponseEntity<Map<String,Map<String,List<Movimento>>>>(movimentos, HttpStatus.OK);
    }
    
     @RequestMapping(value = "/contrib/processar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Map<String,Map<String,List<Movimento>>>> processaArquivosContribuicoes(@RequestParam("process") String contrib) {
        
        
         Map<String,Map<String,List<Movimento>>> movimentos = new HashMap<>();
        if(arquivoContribService.conteudoContribProcessado.size() > 0){
         movimentos = arquivoContribService.conteudoContribProcessado;
        } else{
          movimentos = arquivoContribService.processar(arquivoService);
        }
        return new ResponseEntity<Map<String,Map<String,List<Movimento>>>>(movimentos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/home/clear", method = RequestMethod.POST)
    public ResponseEntity<String> clearListas (@RequestParam("process") String clear) {

           arquivoService.clearListas();
           arquivoContribService.conteudoContribProcessado.clear();
           arquivoFiscalService.conteudoFiscalProcessado.clear();
            return new ResponseEntity<String>(new String("Memoria liberada"), HttpStatus.OK);
        
    }
}
