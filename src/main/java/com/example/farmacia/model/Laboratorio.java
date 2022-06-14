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
 * @author KEILA
 */
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Laboratorio {
    private int idlaboratorio;
    private String nombre;
    private String direccion;
    private String telefono;
    private Boolean estado;
}
