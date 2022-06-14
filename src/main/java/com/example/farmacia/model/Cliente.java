/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.farmacia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Lisbeth
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private int idcliente;
    private String nombres;
    private String apellidos;
    private String sexo;
    private String dni;
    private String telefono;
    private String ruc; 
    private String email;
    private String direccion;
}
