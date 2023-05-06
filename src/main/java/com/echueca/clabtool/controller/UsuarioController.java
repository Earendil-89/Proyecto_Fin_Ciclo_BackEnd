package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.service.interfaces.IUsuarioService;
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
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/usuario")
    public List<Usuario> getUsuario() throws JsonProcessingException, IOException {
        return this.usuarioService.getUsuario();
    }
    
    @GetMapping("/usuario/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) throws JsonProcessingException, IOException { 
        return this.usuarioService.getUsuarioById(id);
    }
    
    @PostMapping("/usuario")
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) throws JsonProcessingException, IOException {
        return this.usuarioService.saveUsuario(usuario);
    }
    
    @PutMapping("/usuario")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) throws JsonProcessingException, IOException {
        return this.usuarioService.updateUsuario(usuario);
    }
    
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> deleteUsuarioById(@PathVariable Long id) throws JsonProcessingException, IOException  {
        return this.usuarioService.deleteUsuarioById(id);
    }
}