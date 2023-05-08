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
 *
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class EnvasePropController {

    @Autowired
    private IEnvasePropService envasePropService;
    
    @GetMapping("/envaseProp")
    public List<EnvaseProp> getEnvase() {
        return this.envasePropService.getEnvaseProp();
    }
    
    @PostMapping("/envaseProp")
    public ResponseEntity<?> saveEnvase(@RequestBody EnvaseProp envaseProp) {
        return this.envasePropService.saveEnvaseProp(envaseProp);
    }
    
    @PutMapping("/envaseProp")
    public ResponseEntity<?> updateEnvase(@RequestBody EnvaseProp envaseProp) {
        return this.envasePropService.updateEnvaseProp(envaseProp);
    }
    
    @DeleteMapping("/envaseProp")
    public ResponseEntity<?> deleteEnvase(@PathVariable Long id) {
        return this.envasePropService.deleteEnvaseProp(id);
    }
}
