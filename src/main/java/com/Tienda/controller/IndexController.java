package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
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
    private ClienteService clienteService;
    @GetMapping("/")
    public String inicio(Model model){
       log.info("Estamos usando una arquitectura mvc");
       
       /*Cliente cliente = new Cliente("Pedro","Gomez","josema@gmail.com","88888888");
       Cliente cliente2 = new Cliente("John","Bones","Bone@gmail.com","77777777");
       
       var clientes = Arrays.asList(cliente,cliente2);
       
       
       model.addAttribute("cliente",cliente);
        model.addAttribute("clientes",clientes);*/
       
       var clientes = clienteService.getClientes();
       model.addAttribute("clientes",clientes);
       
       var temp = new Cliente();
       temp.setIdCliente(Long.parseLong("1"));
       
       var cliente = clienteService.getCliente(temp);
       model.addAttribute("cliente",cliente);
       return "index";
    }
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
    
    
}
