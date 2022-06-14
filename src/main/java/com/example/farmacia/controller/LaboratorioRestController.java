 package com.example.farmacia.controller;

import com.example.farmacia.model.Laboratorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.farmacia.service.LaboratorioService;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/laboratorio")
public class LaboratorioRestController {
    
    @Autowired
    private LaboratorioService laboratorioService;
    
    @GetMapping("/all")
    public List<Laboratorio> getLaboratorios(){
        return laboratorioService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> getLaboratorio(@PathVariable int id){
        Laboratorio actor = laboratorioService.findById(id);
        return ResponseEntity.ok(actor);
    }
    
    @DeleteMapping("/{id}")
    public void deleteLabratorio(@PathVariable int id) {        
        laboratorioService.deleteById(id);
    }
    @PostMapping("/add")
    public int addLaboratorio(@RequestBody Laboratorio laboratorio) {  
        return laboratorioService.insert(laboratorio);
    }
    @PutMapping("/edit")
    public int editLaboratorio(@RequestBody Laboratorio laboratorio) {  
        Laboratorio lab = new Laboratorio(laboratorio.getIdlaboratorio(),laboratorio.getNombre(),laboratorio.getDireccion(), laboratorio.getTelefono(), laboratorio.getEstado());
        return laboratorioService.update(laboratorio);
    }
}
