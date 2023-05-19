package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Unidad;
import com.echueca.clabtool.repository.UnidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class UnidadController {
    
    @Autowired
    private UnidadRepository unidadRepository;
    
    @GetMapping("/unidad")
    public List<Unidad> getUnidad() {
        return this.unidadRepository.findByOrderById();
    }
}
