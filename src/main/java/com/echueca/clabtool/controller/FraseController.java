/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Frase;
import com.echueca.clabtool.service.interfaces.IFraseService;
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
public class FraseController {
    
    @Autowired
    private IFraseService fraseService;
    
    @GetMapping("/frase")
    public List<Frase> getFrase() throws JsonProcessingException, IOException {
        return this.fraseService.getFrase();
    }
    
    @GetMapping("/frase/{id}")
    public Frase getFraseById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.fraseService.getFraseById(id);
    }
    
    @PostMapping("/frase")
    public ResponseEntity<?> saveFrase(@RequestBody Frase frase) throws JsonProcessingException, IOException {
        this.fraseService.saveFrase(frase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase creada."));
    }
    
    @PutMapping("/frase")
    public ResponseEntity<?> updateFrase(@RequestBody Frase frase) throws JsonProcessingException, IOException {
        this.fraseService.updateFrase(frase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase actualizada."));
    }
    
    @DeleteMapping("/frase/{id}")
    public ResponseEntity<?> deleteFrase(@PathVariable Long id) throws JsonProcessingException, IOException {
        this.fraseService.deleteFrase(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase borrada"));
    }
}
