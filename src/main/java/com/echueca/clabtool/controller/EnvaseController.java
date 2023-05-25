package com.echueca.clabtool.controller;

import com.echueca.clabtool.DTO.EnvaseReturnDTO;
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
 *
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin
@RestController
@RequestMapping("/api/clabtool")
public class EnvaseController {
   
    @Autowired
    private IEnvaseService envaseService;
    
    @GetMapping("/manager/envase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<Envase> getEnvase() {
        return this.envaseService.getEnvase();
    }
    
    @GetMapping("/user/envase")
    @PreAuthorize("hasRole('USER')")
    public List<EnvaseReturnDTO> getEnvaseAsUser(@RequestParam(required = false) Long compuestoId,
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Double pureza ) {
        
        if( compuestoId == null && codigo == null && nombre == null ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid search parameters");
        }
        
        EnvaseSearchDTO envase = new EnvaseSearchDTO(compuestoId, codigo, nombre, pureza);
        return this.envaseService.getEnvaseAsUser(envase);
    }
    
    @PostMapping("/envase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> saveEnvase(@RequestBody Envase envase) {
        return this.envaseService.saveEnvase(envase);
    }
    
    @PutMapping("/envase")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> updateEnvase(@RequestBody Envase envase) {
        return this.envaseService.updateEnvase(envase);
    }
    
    @DeleteMapping("/envase/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> deleteEnvase(@PathVariable Long id) {
        return this.envaseService.deleteEnvase(id);
    }
}