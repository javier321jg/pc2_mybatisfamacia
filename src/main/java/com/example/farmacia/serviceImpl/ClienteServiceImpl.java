/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.farmacia.serviceImpl;

import com.example.farmacia.model.Cliente;
import com.example.farmacia.repository.ClienteMyBatisRepository;
import com.example.farmacia.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lisbeth
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteMyBatisRepository batisRepository;

    @Override
    public List<Cliente> findAll() {
        return batisRepository.findAll();
    }

    @Override
    public Cliente findById(long id) {
        return batisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
        return batisRepository.deleteById(id);
    }

    @Override
    public int insert(Cliente cliente) {
        return batisRepository.insert(cliente);
    }

    @Override
    public int update(Cliente cliente) {
        return batisRepository.update(cliente);
    }
    
}
