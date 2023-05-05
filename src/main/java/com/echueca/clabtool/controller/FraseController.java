/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Frase;
import com.echueca.clabtool.repository.FraseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class FraseController {
    
    @Autowired
    private FraseRepository fraseRepository;
    
    @GetMapping("/frase")
    public List<Frase> getFrase() throws JsonProcessingException, IOException {
        return this.fraseRepository.findAll();
    }
    
    @GetMapping("/frase/{id}")
    public Frase getFraseById(@PathVariable String id) throws JsonProcessingException, IOException {
        return this.fraseRepository.findById(id).get();
    }
    
    @PostMapping("/frase")
    public ResponseEntity<?> saveFrase(@RequestBody Frase frase) throws JsonProcessingException, IOException {
        fraseRepository.save(frase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase creada."));
    }
    
    @PutMapping("/frase")
    public ResponseEntity<?> updateFrase(@RequestBody Frase frase) throws JsonProcessingException, IOException {
        fraseRepository.save(frase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase actualizada."));
    }
    
    @DeleteMapping("/frase/{id}")
    public ResponseEntity<?> deleteFrase(@PathVariable String id) throws JsonProcessingException, IOException {
        fraseRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase borrada"));
    }
}
