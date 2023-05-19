package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Estante;
import com.echueca.clabtool.service.interfaces.IEstanteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clabtool")
public class EstanteController {
    
    @Autowired
    private IEstanteService estanteService;
    
    @GetMapping("/estante")
    public List<Estante> getEstante() throws JsonProcessingException, IOException {
        return this.estanteService.getEstante();
    } 
    
    @GetMapping("/estante/{id}")
    public Estante getEstanteById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.estanteService.getEstanteById(id);
    }
    
    @GetMapping("/estante?armarioId={id}")
    public List<Estante> getEstanteByArmarioId(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.estanteService.getEstanteByArmarioId(id);
    }
    
    @PostMapping("/estante")
    public ResponseEntity<?> saveEstante(@RequestBody Estante estante) throws JsonProcessingException, IOException {
        return this.estanteService.saveEstante(estante);
    }
    
    @PutMapping("/estante")
    public ResponseEntity<?> updateEstante(@RequestBody Estante estante) throws JsonProcessingException, IOException {
        return this.estanteService.updateEstante(estante);
    }
    
    @DeleteMapping("/estante/{id}")
    public ResponseEntity<?> deleteEstante(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.estanteService.deleteEstante(id);
    }
}
