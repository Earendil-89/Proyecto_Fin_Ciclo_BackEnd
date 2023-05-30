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
 * Procesa peticiones HTTP para realizar un CRUD en la base de datos
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clabtool")
public class ArmarioController {
    
    @Autowired
    private IArmarioService armarioService;
    
    /**
     * Solicita todos los armarios almacenados en la base de datos
     * @return Lista de armarios
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/armario")
    @PreAuthorize("hasRole('INSPECTOR') or hasRole('USER') or hasRole('ADMIN')")
    public Iterable<Armario> getArmario() throws JsonProcessingException, IOException {
        return this.armarioService.getArmario();
    }
    
    /**
     * Devuelve un armario de la base de datos en base al ID insertado como variable de ruta
     * @param id ID del armario
     * @return Mensaje de resultado de la operación
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/armario/{id}")
    @PreAuthorize("hasRole('INSPECTOR') or hasRole('USER') or hasRole('ADMIN')")
    public Armario getArmarioById(@PathVariable Long id) throws JsonProcessingException, IOException { 
        return this.armarioService.getArmarioById(id);
    }
    
    /**
     * Inserta un nuevo armario en la base de datos
     * @param armario Armario a guardar
     * @return Mensaje de resultado de la operación
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PostMapping("/armario")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> saveArmario(@RequestBody Armario armario) throws JsonProcessingException, IOException {
        return this.armarioService.saveArmario(armario);
    }
    
    /**
     * Modifica un armario existente en la base de datos
     * @param armario Armario a editar
     * @return Mensaje de resultado de la operación
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PutMapping("/armario")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> updateArmario(@RequestBody Armario armario) throws JsonProcessingException, IOException {
        return this.armarioService.updateArmario(armario);
    }
    
    /**
     * Borra un armario de la base de datos
     * @param id ID del armario de la base de datos
     * @return Mensaje de resultado de la operación
     * @throws JsonProcessingException
     * @throws IOException
     */
    @DeleteMapping("/armario/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> deleteArmarioById(@PathVariable Long id) throws JsonProcessingException, IOException  {
        return this.armarioService.deleteArmario(id);
    }
}