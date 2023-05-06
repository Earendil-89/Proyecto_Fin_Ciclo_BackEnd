package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Etiqueta;
import com.echueca.clabtool.repository.EtiquetaRepository;
import com.echueca.clabtool.service.interfaces.IEtiquetaService;
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
public class EtiquetaController {
    
    @Autowired
    private IEtiquetaService etiquetaService;
    
    @GetMapping("/etiqueta")
    public List<Etiqueta> getEtiqueta() throws JsonProcessingException, IOException {
        return this.etiquetaService.getEtiqueta();
    }
    
    @GetMapping("/etiqueta/{id}")
    public Etiqueta getEtiquetaById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.etiquetaService.getEtiquetaById(id);
    }
    
    @PostMapping("/etiqueta")
    public ResponseEntity<?> saveEtiqueta(@RequestBody Etiqueta etiqueta) throws JsonProcessingException, IOException {
        return this.etiquetaService.saveEtiqueta(etiqueta);
    }
    
    @PutMapping("/etiqueta")
    public ResponseEntity<?> updateEtiqueta(@RequestBody Etiqueta etiqueta) throws JsonProcessingException, IOException {
        return this.etiquetaService.updateEtiqueta(etiqueta);
    }
    
    @DeleteMapping("/etiqueta/{id}")
    public ResponseEntity<?> deleteEtiqueta(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.etiquetaService.deleteEtiqueta(id);
    }
}
