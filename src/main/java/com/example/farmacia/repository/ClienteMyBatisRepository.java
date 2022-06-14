/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.farmacia.repository;
import com.example.farmacia.model.Cliente;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Lisbeth
 */
@Mapper
public interface ClienteMyBatisRepository {
    @Select ("select *from cliente")
    public List<Cliente> findAll();
    
    @Select ("SELECT *FROM cliente WHERE idcliente =#{id}")
    public Cliente findById(long id);
    

    @Delete("DELETE FROM cliente WHERE idcliente = #{id}")
    public int deleteById(long id);

    @Insert("INSERT INTO cliente(nombres,apellidos,sexo,dni,telefono,ruc,email,direccion) VALUES (#{nombres},#{apellidos},#{sexo},#{dni},#{telefono},#{ruc},#{email}, #{direccion})")
    public int insert(Cliente cliente);

    @Update("Update cliente set nombres=#{nombres},apellidos=#{apellidos}, sexo=#{sexo},dni=#{dni}, telefono=#{telefono}, ruc=#{ruc},email=#{email},direccion=#{direccion} where idcliente=#{idcliente}")
    public int update(Cliente cliente);
        
}