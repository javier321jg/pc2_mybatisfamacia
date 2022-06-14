/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.farmacia.serviceImpl;
import com.example.farmacia.service.ProductoService;
import com.example.farmacia.model.Producto;
import com.example.farmacia.repository.ProductoMyBatisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author javier_gr
 */
public class ProductoServiceImpl implements ProductoService{
     @Autowired
    private ProductoMyBatisRepository productoMyBatisRepository;
   @Override
    public List<Producto> findAll() {
        return productoMyBatisRepository.findAll();
    }

    @Override
    public Producto findById(long id) {
        return productoMyBatisRepository.findById(id);
    }

    @Override
    public int deleteById(long id) {
        return productoMyBatisRepository.delete(id);
    }

    @Override
    public int insert(Producto producto) {
        return productoMyBatisRepository.insert(producto);
    }

    @Override
    public int update(Producto producto) {
        return productoMyBatisRepository.update(producto);
    }
    
}
