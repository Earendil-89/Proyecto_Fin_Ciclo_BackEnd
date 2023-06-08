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
 * Procesa peticiones HTTP para realizar un CRUD en la base de datos
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clabtool")
public class FraseController {
    
    @Autowired
    private IFraseService fraseService;
    
    /**
     * Devuelve las frases almacenadas en la base de datos
     * @return Lista de frases
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/frase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<Frase> getFrase() throws JsonProcessingException, IOException {
        return this.fraseService.getFrase();
    }
    
    /**
     * Realiza una búsqueda de frase por ID
     * @param id ID de la frase a buscar
     * @return Frase si la búsqueda fué satisfactoria, falso en caso contrario
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/frase/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public Frase getFraseById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.fraseService.getFraseById(id);
    }
    
    /**
     * Inserta una nueva frase en la base de datos
     * @param frase Frase a insertar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PostMapping("/frase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> saveFrase(@RequestBody Frase frase) throws JsonProcessingException, IOException {
        this.fraseService.saveFrase(frase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase creada."));
    }
    
    /**
     * Actualiza una frase en la base de datos
     * @param frase Frase a actualizar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PutMapping("/frase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> updateFrase(@RequestBody Frase frase) throws JsonProcessingException, IOException {
        this.fraseService.updateFrase(frase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase actualizada."));
    }
    
    /**
     * Borra una frase de la base de datos
     * @param id Id de la frase a borrar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @DeleteMapping("/frase/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> deleteFrase(@PathVariable Long id) throws JsonProcessingException, IOException {
        this.fraseService.deleteFrase(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase borrada"));
    }
}
