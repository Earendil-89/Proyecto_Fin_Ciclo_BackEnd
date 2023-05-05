package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Armario;
import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.repository.ArmarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Optional;
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
public class ArmarioController {
    
    @Autowired
    private ArmarioRepository armarioRepository;
    
    @GetMapping("/armario")
    public Iterable<Armario> getArmario() throws JsonProcessingException, IOException {
        return this.armarioRepository.findAll();
    }
    
    @GetMapping("/armario/{id}")
    public Optional<Armario> getArmarioById(@PathVariable Integer id) throws JsonProcessingException, IOException { 
        return this.armarioRepository.findById(id);
    }
    
    @PostMapping("/armario")
    public ResponseEntity<?> saveArmario(@RequestBody Armario armario) throws JsonProcessingException, IOException {
        this.armarioRepository.save(armario);
        return ResponseEntity.ok("Armario creado.");
    }
    
    @PutMapping("/armario")
    public ResponseEntity<?> updateArmario(@RequestBody Armario armario) throws JsonProcessingException, IOException {
        this.armarioRepository.save(armario);
        return ResponseEntity.ok("Armario actualizado.");
    }
    
    @DeleteMapping("/armario/{id}")
    public ResponseEntity<?> deleteArmarioById(@PathVariable Integer id) throws JsonProcessingException, IOException  {
        this.armarioRepository.deleteById(id);
        return ResponseEntity.ok("Armario borrado");
    }
}
