package com.echueca.clabtool.controller;

import com.echueca.clabtool.DTO.EnvaseResponseDTO;
import com.echueca.clabtool.DTO.EnvaseSearchDTO;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.service.interfaces.IEnvaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

/**
 * Procesa peticiones HTTP para realizar un CRUD en la base de datos
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin
@RestController
@RequestMapping("/api/clabtool")
public class EnvaseController {
   
    @Autowired
    private IEnvaseService envaseService;
    
    /**
     * Solicita todos los envases almacenados en la base de datos
     * @return Lista con todos los envases
     */
    @GetMapping("/manager/envase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<Envase> getEnvase() {
        return this.envaseService.getEnvase();
    }
    
    /**
     * Devuelve resultados de una búsqueda de envases a los usuarios con rol USER.
     * Al menos un parámetro, sin contar pureza, debe de ser enviado.
     * No se envia información con la localización del envase.
     * @param compuestoId ID de compuesto químico
     * @param codigo Código de envase
     * @param nombre Nombre del compuesto químico o del envase
     * @param pureza Pureza mínima
     * @return
     */
    @GetMapping("/user/envase")
    @PreAuthorize("hasRole('USER')")
    public List<EnvaseResponseDTO> getEnvaseAsUser(@RequestParam(required = false) Long compuestoId,
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Double pureza ) {
        
        if( compuestoId == null && codigo == null && nombre == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search parameters");
        }
        
        EnvaseSearchDTO envase = new EnvaseSearchDTO(compuestoId, codigo, nombre, pureza);
        return this.envaseService.getEnvaseAsUser(envase);
    }
    
    /**
     * Inserta un nuevo envase en la base de datos
     * @param envase Envase a insertar
     * @return
     */
    @PostMapping("/envase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> saveEnvase(@RequestBody Envase envase) {
        return this.envaseService.saveEnvase(envase);
    }
    
    /**
     * Actualiza un envase existente en la base de datos
     * @param envase Envase a actualizar
     * @return
     */
    @PutMapping("/envase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> updateEnvase(@RequestBody Envase envase) {
        return this.envaseService.updateEnvase(envase);
    }
    
    /**
     * Elimina un envase de la base de datos
     * @param id ID del envase a borrar
     * @return
     */
    @DeleteMapping("/envase/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> deleteEnvase(@PathVariable Long id) {
        return this.envaseService.deleteEnvase(id);
    }
}