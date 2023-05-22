package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Armario;
import com.echueca.clabtool.service.interfaces.IArmarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class ArmarioController {
    
    @Autowired
    private IArmarioService armarioService;
    
    @GetMapping("/armario")
    @PreAuthorize("hasRole('INSPECTOR') or hasRole('USER') or hasRole('ADMIN')")
    public Iterable<Armario> getArmario() throws JsonProcessingException, IOException {
        return this.armarioService.getArmario();
    }
    
    @GetMapping("/armario/{id}")
    @PreAuthorize("hasRole('INSPECTOR') or hasRole('USER') or hasRole('ADMIN')")
    public Armario getArmarioById(@PathVariable Long id) throws JsonProcessingException, IOException { 
        return this.armarioService.getArmarioById(id);
    }
    
    @PostMapping("/armario")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> saveArmario(@RequestBody Armario armario) throws JsonProcessingException, IOException {
        return this.armarioService.saveArmario(armario);
    }
    
    @PutMapping("/armario")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> updateArmario(@RequestBody Armario armario) throws JsonProcessingException, IOException {
        return this.armarioService.updateArmario(armario);
    }
    
    @DeleteMapping("/armario/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> deleteArmarioById(@PathVariable Long id) throws JsonProcessingException, IOException  {
        return this.armarioService.deleteArmario(id);
    }
}