/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.farmacia.controller;

import com.example.farmacia.model.Cliente;
import com.example.farmacia.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lisbeth
 */
@RestController
@RequestMapping ("/cliente")
public class ClienteRestController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/all")
    public List<Cliente> getClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable int id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable int id) {        
        clienteService.deleteById(id);
    }
    @PostMapping("/add")
    public int addCliente(@RequestBody Cliente cliente) {  
        return clienteService.insert(cliente);
    }
    @PutMapping("/edit")
    public int editCliente(@RequestBody Cliente cliente) {  
        Cliente cl = new Cliente(cliente.getIdcliente(),cliente.getNombres(),cliente.getApellidos(),cliente.getSexo(),cliente.getDni(),cliente.getTelefono(), cliente.getRuc(), cliente.getEmail(), cliente.getDireccion());
        return clienteService.update(cliente);
    }    
}
