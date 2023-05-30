package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.EnvaseProp;
import com.echueca.clabtool.service.interfaces.IEnvasePropService;
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
 * Procesa peticiones HTTP para realizar un CRUD en la base de datos
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class EnvasePropController {

    @Autowired
    private IEnvasePropService envasePropService;
    
    /**
     * Solicita todas las propiedades de envases almacenadas en la base de datos
     * @return Lista con las propiedades de envases
     */
    @GetMapping("/envaseProp")
    public List<EnvaseProp> getEnvaseProp() {
        return this.envasePropService.getEnvaseProp();
    }
    
    /**
     * Inserta una nueva propiedad de envases en la base de datos
     * @param envaseProp Propiedades de envase a insertar
     * @return Mensaje de respuesta
     */
    @PostMapping("/envaseProp")
    public ResponseEntity<?> saveEnvaseProp(@RequestBody EnvaseProp envaseProp) {
        return this.envasePropService.saveEnvaseProp(envaseProp);
    }
    
    /**
     * Actualiza una propiedad de envases existente en la base de datos
     * @param envaseProp Propiedad de envases a actualizar
     * @return mensaje de respuesta
     */
    @PutMapping("/envaseProp")
    public ResponseEntity<?> updateEnvaseProp(@RequestBody EnvaseProp envaseProp) {
        return this.envasePropService.updateEnvaseProp(envaseProp);
    }
    
    /**
     * Elimina una propiedad de envases presente en la base de datos
     * @param id ID de la propiedad de envases a eliminar
     * @return Mensaje de respuesta
     */
    @DeleteMapping("/envaseProp/{id}")
    public ResponseEntity<?> deleteEnvaseProp(@PathVariable Long id) {
        return this.envasePropService.deleteEnvaseProp(id);
    }
}
