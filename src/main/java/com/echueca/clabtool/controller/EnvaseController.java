package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.service.interfaces.IEnvaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PreAuthorize("hasRole('ADMIN')")
    public List<Envase> getEnvase() {
        return this.envaseService.getEnvase();
    }
    
    
    @PostMapping("/envase")
    public ResponseEntity<?> saveEnvase(@RequestBody Envase envase) {
        return this.envaseService.saveEnvase(envase);
    }
    
    @PutMapping("/envase")
    public ResponseEntity<?> updateEnvase(@RequestBody Envase envase) {
        return this.envaseService.updateEnvase(envase);
    }
    
    @DeleteMapping("/envase")
    public ResponseEntity<?> deleteEnvase(@RequestBody Long id) {
        return this.envaseService.deleteEnvase(id);
    }
}