/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.farmacia.service;

import com.example.farmacia.model.Producto;
import java.util.List;

/**
 *
 * @author javier_gr
 */
public interface ProductoService {
    public List<Producto> findAll();
    public Producto findById(long id);
    public int deleteById(long id);
    public int insert(Producto producto);
    public int update(Producto producto);
}
