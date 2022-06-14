/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.farmacia.serviceImpl;

import com.example.farmacia.model.Laboratorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.farmacia.service.LaboratorioService;
import com.example.farmacia.repository.LaboratorioMyBatisRepository;

/**
 *
 * @author KEILA
 */
@Service

public class LaboratorioServiceImpl implements LaboratorioService {
    @Autowired
    private LaboratorioMyBatisRepository laboratorioMyBatisRepository;

    @Override
    public List<Laboratorio> findAll() {
        return laboratorioMyBatisRepository.findAll();
    }

    @Override
    public Laboratorio findById(long id) {
        return laboratorioMyBatisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
        return laboratorioMyBatisRepository.delete(id);
    }

    @Override
    public int insert(Laboratorio laboratorio) {
        return laboratorioMyBatisRepository.insert(laboratorio);
    }

    @Override
    public int update(Laboratorio laboratorio) {
        return laboratorioMyBatisRepository.update(laboratorio);
                
               
    }
    
}
