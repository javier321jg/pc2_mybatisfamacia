/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.farmacia.repository;

import com.example.farmacia.model.Producto;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author javier_gr
 */
public interface ProductoMyBatisRepository {
    @Insert("INSERT INTO producto(idproducto,descripcion,consentracion,stock,precio_venta,registrosanitario,fechavencimiento) VALUES (#{descripcion},#{consentracion{,#{stock},#{precio_venta},#{registrosanitario},#{fechavencimiento})")
    public int insert(Producto producto);
    
    @Insert("UPDATE producto SET descripcion=#{descripcion}, consentracion=#{consentracion},stock=#{stock},precio_venta=#{precio_venta},registrosanitario=#{registrosanitario},fechavencimiento=#{fechavencimiento} WHERE idproducto=#{idproducto}")
    public int update(Producto producto);
    
    @Delete("DELETE FROM producto WHERE idproducto=#{id}")
    public int delete(long id);
    
    @Select("SELECT *FROM producto WHERE idproducto=#{id}")
    public Producto findById(long id);
    
    @Select("SELECT *FROM producto")
    public List<Producto> findAll();

    
}
