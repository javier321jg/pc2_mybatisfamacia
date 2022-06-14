/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.farmacia.repository;

import com.example.farmacia.model.Laboratorio;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author KEILA
 */
@Mapper
public interface LaboratorioMyBatisRepository {
    @Insert("INSERT INTO laboratorio(nombre, direccion, telefono, estado) VALUES(#{nombre},#{apellido},#{correo},#{estado})")
    public int insert(Laboratorio laboratorio);
    
    @Insert("UPDATE laboratorio SET nombre=#{nombre}, direccion=#{direccion}, telefono=#{telefono}, estado=#{estado} WHERE idlaboratorio=#{idlaboratorio}")
    public int update(Laboratorio laboratorio);
       
    @Delete("DELETE FROM laboratorio WHERE idlaboratorio=#{id}")
    public int delete(long id);
    
    @Select("SELECT *FROM laboratorio WHERE idlaboratorio=#{id}")
    public Laboratorio findById(long id);
    
    @Select("SELECT *FROM laboratorio")
    public List<Laboratorio> findAll();


    }
