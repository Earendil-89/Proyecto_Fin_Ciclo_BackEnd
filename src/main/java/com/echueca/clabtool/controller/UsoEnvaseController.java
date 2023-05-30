package com.echueca.clabtool.controller;

import com.echueca.clabtool.DTO.EnvaseExtractDTO;
import com.echueca.clabtool.model.UsoEnvase;
import com.echueca.clabtool.service.interfaces.IUsoEnvaseService;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Procesa peticiones HTTP para realizar un CRUD en la base de datos
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin
@RestController
@RequestMapping("/api/clabtool")
public class UsoEnvaseController {
    
    @Autowired
    private IUsoEnvaseService usoEnvaseService;
    
    /**
     * Devuelve los usos de envase almacenados en la base de datos
     * @return Lista de usos de envase
     */
    @GetMapping("/manager/usoEnvase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<UsoEnvase> getUsoEnvase() {
        return this.usoEnvaseService.getUsoEnvase();
    }
    
    /**
     * Devuelve usos de envase filtrados por nombre de usuario
     * @param nombreUsuario Nombre del usuario que usó el envase
     * @return Lista de usos de envase
     */
    @GetMapping("/usoEnvase")
    @PreAuthorize("hasRole('USER') or hasRole('INSPECTOR')")
    public List<UsoEnvase> getUsoEnvaseUser(@RequestParam String nombreUsuario) {
        return this.usoEnvaseService.getActiveUsoEnvaseByNombreUsuario(nombreUsuario);
    }
    
    /**
     * Registra una extracción de envase por parte de un trabajador en la base de datos
     * @param extr Datos de envase a extraer
     * @return Mensaje de respuesta
     */
    @PostMapping("/usoEnvase")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> saveUsoEnvase(@RequestBody EnvaseExtractDTO extr) {
        return this.usoEnvaseService.saveUsoEnvase(extr);
    }
    
    /**
     * Actualiza un uso de envase existente en la base de datos
     * @param usoEnvase uso de envase a actualizar
     * @return Mensaje de respuesta
     */
    @PutMapping("/usoEnvase")
    @PreAuthorize("hasRole('USER') or hasRole('INSPECTOR')")
    public ResponseEntity<?> updateUsoEnvase(@RequestBody UsoEnvase usoEnvase) {
        
        if( usoEnvase.getFechaDevolucion() == null ) {
            usoEnvase.setFechaDevolucion(new Date());
        }
        return this.usoEnvaseService.updateUsoEnvase(usoEnvase);
    }
    
    /**
     * Borra un uso de envase en la base de datos
     * @param id ID del uso de envase
     * @return Mensaje de respuesta
     */
    @DeleteMapping("/usoEnvase/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> deleteUsoEnvase(@PathVariable Long id) {
        return this.usoEnvaseService.deleteUsoEnvase(id);
    }
}
