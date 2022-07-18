package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import com.Tienda.service.ArticuloService;
import com.Tienda.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j 
public class IndexController {
    
    @Autowired
    private ArticuloService articuloService;
    @GetMapping("/")
    public String inicio(Model model){
       log.info("Estamos usando una arquitectura mvc");
       
       /*Cliente cliente = new Cliente("Pedro","Gomez","josema@gmail.com","88888888");
       Cliente cliente2 = new Cliente("John","Bones","Bone@gmail.com","77777777");
       
       var clientes = Arrays.asList(cliente,cliente2);
       
       
       model.addAttribute("cliente",cliente);
        model.addAttribute("clientes",clientes);*/
       
       var articulos = articuloService.getArticulos(true);
       model.addAttribute("articulos",articulos);
       
       return "index";
    }
    
    
}
