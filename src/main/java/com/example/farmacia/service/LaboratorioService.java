/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.farmacia.service;

import com.example.farmacia.model.Laboratorio;
import java.util.List;

/**
 *
 * @author KEILA
 */
public interface LaboratorioService {
    public List<Laboratorio> findAll();
    public Laboratorio findById(long id);
    public int deleteById(long id);
    public int insert(Laboratorio laboratorio);
    public int update(Laboratorio laboratorio);
}
