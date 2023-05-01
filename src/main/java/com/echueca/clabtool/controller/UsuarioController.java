package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.repository.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Optional;
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
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/usuario")
    public Iterable<Usuario> getUsuario() throws JsonProcessingException, IOException {
        return this.usuarioRepository.findAll();
    }
    
    @GetMapping("/usuario/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable String id) throws JsonProcessingException, IOException { 
        return this.usuarioRepository.findById(id);
    }
    
    @PostMapping("/usuario")
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) throws JsonProcessingException, IOException {
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario creado.");
    }
    
    @PutMapping("/usuario")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) throws JsonProcessingException, IOException {
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario actualizado.");
    }
    
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> deleteUsuarioById(@PathVariable String id) throws JsonProcessingException, IOException  {
        this.usuarioRepository.deleteById(id);
        return ResponseEntity.ok("Usuario borrado");
    }
}
