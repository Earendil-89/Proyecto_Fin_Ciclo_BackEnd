package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.service.interfaces.ICompuestoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class CompuestoController {
    
    @Autowired
    private ICompuestoService compuestoService;
    
    @GetMapping("/compuesto")
    public List<Compuesto> getCompuesto() throws JsonProcessingException, IOException {
        return this.compuestoService.getCompuesto();
    }
    
    @GetMapping("/compuesto/{id}")
    public Compuesto getCompuestoById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.compuestoService.getCompuestoById(id);
    }
    
    @PostMapping("/compuesto")
    public ResponseEntity<?> saveCompuesto(@RequestBody Compuesto compuesto) throws JsonProcessingException, IOException {
        return this.compuestoService.saveCompuesto(compuesto);
    }
    
    @PutMapping("/compuesto")
    public ResponseEntity<?> updateCompuesto(@RequestBody Compuesto compuesto) throws JsonProcessingException, IOException {
        return this.compuestoService.updateCompuesto(compuesto);
    }
}
