package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.service.interfaces.IUsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
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
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clabtool")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    /**
     * Devuelve los usuarios almacenados en la base de datos
     * @return Lista de usuarios
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/usuario")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario> getUsuario() throws JsonProcessingException, IOException {
        return this.usuarioService.getUsuario();
    }
    
    /**
     * Realiza una busqueda de usuario por su ID
     * @param id ID del usuario
     * @return Usuario si la busqueda fue satisfactoria, nulo en caso contrario
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/usuario/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Usuario getUsuarioById(@PathVariable Long id) throws JsonProcessingException, IOException { 
        return this.usuarioService.getUsuarioById(id);
    }
    
    /**
     * Realiza una busqueda de usuario por su nombre de usuario
     * @param nombreUsuario Nombre de usuario a buscar
     * @return Usuario si la busqueda fue satisfactoria, nulo en caso contrario
     */
    @GetMapping("/usuario")
    @PreAuthorize("hasRole('ADMIN') or hasRole('INSPECTOR') or hasRole('USER')")
    public String getUsuarioNombreByNombreUsuario(@RequestParam(name = "nombreUsuario") String nombreUsuario) {
        return this.usuarioService.getUsuarioNombreByNombreUsuario(nombreUsuario);
    }
    
    /**
     * Inserta un nuevo usuario en la base de datos
     * @param usuario Usuario a insertar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PostMapping("/usuario")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario) throws JsonProcessingException, IOException {
        return this.usuarioService.saveUsuario(usuario);
    }
    
    /**
     * Actualiza un usuario existente en la base de datos
     * @param usuario Usuario a actualizar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PutMapping("/usuario")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) throws JsonProcessingException, IOException {
        return this.usuarioService.updateUsuario(usuario);
    }
    
    /**
     * Borra un usuario de la base de datos por su ID
     * @param id ID del usuario a borrar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @DeleteMapping("/usuario/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUsuarioById(@PathVariable Long id) throws JsonProcessingException, IOException  {
        return this.usuarioService.deleteUsuarioById(id);
    }
}