package com.Tienda.controller;

import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteReportService;
import com.Tienda.service.ClienteService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteReportService clienteReportService;

    
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model){
      var clientes = clienteService.getClientes();
      model.addAttribute("clientes", clientes);
      return "/clientes/listado";
    }
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    @GetMapping(value = "/cliente/ReporteClientes", produces = MediaType.APPLICATION_PDF_VALUE)
 public @ResponseBody
 byte[] getFile() throws IOException {
 try {
 FileInputStream fis = new FileInputStream(new File(clienteReportService.generateReport()));
 byte[] targetArray = new byte[fis.available()];
 fis.read(targetArray);
 return targetArray;
 } catch (FileNotFoundException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 } catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 return null;
 }

}
