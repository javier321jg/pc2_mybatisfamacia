/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.farmacia.service;

import com.example.farmacia.model.Cliente;
import java.util.List;

/**
 *
 * @author Lisbeth
 */
public interface ClienteService {
    public List<Cliente> findAll();
    public Cliente findById(long id);
    public int deleteById(long id);
    public int insert(Cliente cliente);
    public int update(Cliente cliente);
    
}
