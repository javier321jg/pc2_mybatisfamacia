/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.farmacia.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Lisbeth
 */
public class HomeController {
        @GetMapping("/")
    public String index(){
        return "index";
    }
    
}
