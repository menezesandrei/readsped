package br.com.readsped.service;

import br.com.readsped.model.Arquivo;
import br.com.readsped.model.ArquivoContribuicoes;
import br.com.readsped.model.ArquivoFiscal;
import br.com.readsped.model.Movimento;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoService {
   
    List<ArquivoFiscal> listArquivoFiscal = new ArrayList<>();
    List<ArquivoContribuicoes> listArquivoContrib = new ArrayList<>();
    ArquivoFiscal arquivoFiscal;
    
public void lerArquivos(MultipartFile[] file) 
{
    try{   
        
       
        //StringBuilder stringBuilder = new StringBuilder();
	String line = null;
        ArquivoContribuicoes arquivoContrib;
        ArquivoFiscal arquivoFiscal ;
        int cont;
        boolean ehArquivofiscal;
        String primeiroCampo;
         for(MultipartFile fileUp : file){
            cont = 0;
            ehArquivofiscal = false;
            arquivoContrib = new ArquivoContribuicoes();  
            arquivoFiscal = new ArquivoFiscal();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileUp.getInputStream()));
            
         while ((line = bufferedReader.readLine()) != null) {
             primeiroCampo = line.substring(1, 5);
             
             if (primeiroCampo.equals("9999"))
             {
             break;
             }
             
                if (cont == 0)
                {
                 if(verificaSeArquivoFiscal(line))
                 {
                  ehArquivofiscal = true;
                 }
                }
               cont++;
               
                if(ehArquivofiscal){
                    lerLinhasArquivoFiscal(arquivoFiscal,line);
                    arquivoContrib = null;
                }else{
                 lerLinhasArquivoContrib(arquivoContrib,line);
                 arquivoFiscal = null;
                 }
		}
         
                if(arquivoFiscal != null)
                {
                 this.listArquivoFiscal.add(arquivoFiscal);
                }
                if(arquivoContrib != null)
                {
                this.listArquivoContrib.add(arquivoContrib); 
                }
             
         bufferedReader.close();
         
         
        /*
        String[] linhas;
        String content ;
        //byte[] contet = new Byte("");
        for(MultipartFile fileUp : file){
          
          
          content = IOUtils.toString(fileUp.getInputStream());
          linhas  = content.split("\n");
          content = null;
          System.gc();
         if(verificaSeArquivoFiscal(linhas[0])){
            listArquivoFiscal.add(lerLinhasArquivoFiscal(linhas));
         }
         else
         {
            listArquivoContrib.add(lerLinhasArquivoContrib(linhas));
         }
          content = null;
          linhas = null;
          System.gc();
        }
          */
                 }
       }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
          
}    
private MultipartFile encontraArquivoPeloNome(MultipartFile[] files,String nome)
{
  for(MultipartFile fileUp : files){
  if(fileUp.getName().equals(nome)){
     return fileUp;
   } 
  }
  return null;
  
  
        
}
/*
public void lerArquivoSeparadamente(MultipartFile file) 
{
    try{   
          String[] linhas;
          String content;
          content = new String(file.getBytes());
          linhas  = content.split("\n");
         if(verificaSeArquivoFiscal(linhas[0])){
             listArquivoFiscal.add(lerLinhasArquivoFiscal(linhas));
         }
         else
         {
             listArquivoContrib.add(lerLinhasArquivoContrib(linhas));
         }
        
       }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
}    
*/
private ArquivoFiscal lerLinhasArquivoFiscal(ArquivoFiscal arquivoFiscal,String linha)
{
   
    List<String> camposParaValidar = Arrays.asList("0000","C170","C190","C470","C490","C850","C500","C800");
    

        String primeiroCampo = linha.substring(1, 5);
       linha = linha + "\n";
       
       if(camposParaValidar.contains(primeiroCampo)){
       if(verificaPrimeiroCampo(primeiroCampo,"0000"))
       {
         arquivoFiscal.getRegistro0000().append(linha); 
       }
       
        if(verificaPrimeiroCampo(primeiroCampo,"C170"))
       {
         arquivoFiscal.getRegistrosC170().append(linha); 
       }
        
         if(verificaPrimeiroCampo(primeiroCampo,"C190"))
       {
         arquivoFiscal.getRegistrosC190().append(linha); 
       }
         
          if(verificaPrimeiroCampo(primeiroCampo,"C470"))
       {
         arquivoFiscal.getRegistrosC470().append(linha); 
       }
          
           if(verificaPrimeiroCampo(primeiroCampo,"C490"))
       {
         arquivoFiscal.getRegistrosC490().append(linha); 
       }
           
            if(verificaPrimeiroCampo(primeiroCampo,"C850"))
       {
         arquivoFiscal.getRegistrosC850().append(linha); 
       }
            
            if(verificaPrimeiroCampo(primeiroCampo,"C500"))
       {
         arquivoFiscal.getRegistrosC500().append(linha); 
       }
             
          if(verificaPrimeiroCampo(primeiroCampo,"C800"))
       {
         arquivoFiscal.getRegistrosC800().append(linha); 
       }
    }
    return arquivoFiscal;
}

private ArquivoContribuicoes lerLinhasArquivoContrib(ArquivoContribuicoes arquivoContrib,String linha)
{
    
       String primeiroCampo ;
       List<String> camposParaValidar = Arrays.asList("0000","C170","C175","C181","C190","C481","C491","C810","C870","C501");

 
       primeiroCampo = linha.substring(1, 5);
       linha = linha + "\n";
       
      if(camposParaValidar.contains(primeiroCampo)){
       
       if(verificaPrimeiroCampo(primeiroCampo,"0000"))
       {
         arquivoContrib.getRegistros0000().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C170"))
       {
         arquivoContrib.getRegistrosC170().append(linha); 
       }  
       if(verificaPrimeiroCampo(primeiroCampo,"C175"))
       {
        arquivoContrib.getRegistrosC175().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C181"))
       {
         arquivoContrib.getRegistrosC181().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"185"))
       {
         //arquivoContrib.getRegistrosC185().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C190"))
       {
         arquivoContrib.getRegistrosC190().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C481"))
       {
         arquivoContrib.getRegistrosC481().append(linha); 
       } 
       if(verificaPrimeiroCampo(primeiroCampo,"C485"))
       {
        // arquivoContrib.getRegistrosC485().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C491"))
       {
        arquivoContrib.getRegistrosC491().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C495"))
       {
        // arquivoContrib.getRegistrosC495().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C810"))
       {
         arquivoContrib.getRegistrosC810().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C870"))
       {
         //arquivoContrib.getRegistrosC870().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C501"))
       {
         arquivoContrib.getRegistrosC501().append(linha); 
       }
       if(verificaPrimeiroCampo(primeiroCampo,"C505"))
       {
         //arquivoContrib.getRegistrosC505().append(linha); 
       }
    }
    
    return arquivoContrib;
}

//metodo que verifica se o primeiro campo da linha corresponde ao desejado para atribuir valores ao movimento. 
private boolean verificaPrimeiroCampo(String primeiroCampoArqvuivo, String campo)
{
 if(primeiroCampoArqvuivo.equals(campo))
 {
    return true;
 }else
 {
    return false;
 }
}

/*
private boolean verificaPrimeiroCampoDaLinha(String linha,String reg)
{
  String[] campo = tratarCamposNulosDoArray(linha.split("\\|"),3);  
  if(campo[1].equals(reg))
  {
   return true;
  }
  return false;
}
*/

private boolean verificaSeArquivoFiscal(String linhaPrincipal)
{
 String[] camposPrincipais = tratarCamposNulosDoArray(linhaPrincipal.split("\\|"),16);
 if(camposPrincipais[9].length() == 2)
 {
  return true;
 }
 
 return false;
}

public String[] tratarCamposNulosDoArray(String[] array,int qtdCampos)
	{
		String[] retorno = new String[qtdCampos];
		try {
			for (int i = 0; i < qtdCampos; i++) {
				if (array.length > i) {
					retorno[i] = array[i];
				} else {
					retorno[i] = "";
				}
			}
			return retorno;
		}catch (ArrayIndexOutOfBoundsException|NullPointerException e)
		{
			return array;
		}
	}

   private Set<String> getCstsDosRegistros(String linhasRegistro, int indiceCst) {
        Set<String> csts = new HashSet<>();
       
         String[] linhas = linhasRegistro.split("\n");
         
         for(int i = 0; i <= linhas.length;i++)
         {
           String[] campos = tratarCamposNulosDoArray(linhas[i].split("\\|"), indiceCst + 1);
           csts.add(campos[indiceCst]);
         }
        
       return csts; 
    }
     
   
   // metodo responsavel por encontar os movimentos, ou seja os totais por cst e cfop.
    public List<Movimento>  carregarMovimentos( String linhasRegistro,
            int indiceCst, int indiceCfop, int indiceValor,int indiceBc,int qtdIndicesDoRegistro) {
        
        Movimento movimento; 
       List<Movimento> movimentosEncontrados = new ArrayList<>();
        
        String[] linhas = linhasRegistro.split("\n");
         
            for(int i = 0; i < linhas.length;i++)
            {
                String[] campos = tratarCamposNulosDoArray(linhas[i].split("\\|"),qtdIndicesDoRegistro);
                movimento = new Movimento();
                
                 if(indiceCst == 0){movimento.setCst("0");}else{movimento.setCst(campos[indiceCst]);}
                if(indiceCfop == 0){movimento.setCfop("0");}else{movimento.setCfop(campos[indiceCfop]);}
                  movimento.setValor(new BigDecimal(campos[indiceValor].replace(",", ".")));
                 if(indiceBc == 0){movimento.setValorBc(BigDecimal.ZERO);}
                    else{
                            if(campos[indiceBc].equals(""))
                            {
                              movimento.setValorBc(BigDecimal.ZERO);
                            } else 
                            {
                               movimento.setValorBc(new BigDecimal(campos[indiceBc].replace(",", ".")));
                            }
                        }
                 
                verificaSeMovimentoJaEncontrado(movimento, movimentosEncontrados);
        }
       return movimentosEncontrados; 
    }
    
    private void verificaSeMovimentoJaEncontrado(Movimento mov,List<Movimento> listaMovimento)
    {
        int verifica = 0;
         for (Movimento movimentoDaLista : listaMovimento)
         {
             if(mov.getCst().equals(movimentoDaLista.getCst()) && mov.getCfop().equals(movimentoDaLista.getCfop()))
             {
                 movimentoDaLista.setValor(movimentoDaLista.getValor().add(mov.getValor()));
                 movimentoDaLista.setValorBc(movimentoDaLista.getValorBc().add(mov.getValorBc()));
                 verifica++;
             }
         }
         
         if(verifica == 0)
         {
         listaMovimento.add(mov);
         }
    }
    
    public Arquivo getCabecalhoArquivo(String linha0000,int indiceNome, int indiceCnpj, int indiceData,int qtdRegistros)
    {
        Arquivo arquivo = new Arquivo();
        
        String[]campos = tratarCamposNulosDoArray(linha0000.split("\\|"),qtdRegistros);
        
        arquivo.setNomeClienteArquivo(campos[indiceNome]);
        arquivo.setCnpjClienteArquivo(campos[indiceCnpj]);
        arquivo.setDataArquivo(ajustarDataArquivo(campos[indiceData]));
        
        return arquivo;
    }
    
    private String ajustarDataArquivo(String dataArquivo)
    {
    try{    
    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataArquivo); 
    //Date data =  new Date(dataArquivo);
    Locale local = new Locale("pt","BR");
    DateFormat dateFormat = new SimpleDateFormat("MMMM 'de' yyyy",local); 
    return dateFormat.format(date);
    }
    catch(ParseException e)
    {
        System.out.println(e.getMessage());}
    return dataArquivo;
    }
    
    public void clearListas()
    {
     this.listArquivoContrib.clear();
     this.listArquivoFiscal.clear();
    }
}
