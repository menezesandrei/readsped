package br.com.readsped.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String IrParaindex()
    {
        return "index";
    }

    @RequestMapping("/fiscal")
    public String IrParaPaginaDoArquivoFiscal()
    {
        return "fiscal";
    }
    
     @RequestMapping("/contrib")
    public String IrParaPaginaDoArquivoContribuicoes()
    {
        return "contrib";
    }
}
