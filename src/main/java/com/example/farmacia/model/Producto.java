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
 * @author javier_gr
 */
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Producto {
   
    private int idproducto;
    private String descripcion;
    private String stock;
    private String precio;
    private String registrosanitario;
    private String fechavencimiento;
    
}
