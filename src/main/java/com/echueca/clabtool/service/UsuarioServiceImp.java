package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IUsuarioService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    /**
     * Busca todos los usuarios de la base de datos
     * @return Lista con los usuarios
     */
    @Override
    public List<Usuario> getUsuario() {
        return this.usuarioRepository.findAll();
    }
    
    /**
     * Busca un usuario por su ID
     * @param id ID del usuario
     * @return Usuario en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public Usuario getUsuarioById(Long id) { 
        return this.usuarioRepository.findById(id).get();
    }
    
    /**
     * Inserta un nuevo usuario en la base de datos
     * @param usuario Usuario a insertar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveUsuario(Usuario usuario) {
        // Buscar un usuario que tenga el email
        Usuario userTest = this.usuarioRepository.findByEmail(usuario.getEmail());
        if( userTest != null ) {
            // Abortar la insercion y mandar alerta si el email esta en uso
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El email ya esta en uso por otro usuario."));
        }
        // Guardar usuario
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Usuario creado."));
    }
    
    /**
     * Actualiza un usuario existente en la base de datos
     * @param usuario Usuario a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateUsuario(Usuario usuario) {
        // Buscar un usuario por el email
        Usuario userTest = this.usuarioRepository.findByEmail(usuario.getEmail());
        // Abortar si el email esta en uso por un usuario diferente al que se actualiza
        if( userTest != null && userTest.getId() != usuario.getId() )  {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El email ya esta en uso por otro usuario."));
        }
            
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Usuario actualizado."));
    }
    
    /**
     * Elimina un usuario de la base de datos
     * @param id ID del usuario a eliminar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteUsuarioById(Long id ){
        this.usuarioRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Usuario borrado"));
    }
    
    /**
     * Devuelve el nombre real de un usuario a partir de su nombre de usuario
     * @param nombreUsuario Nombre de usuario a buscar
     * @return Nombre del usuario
     */
    @Override
    public String getUsuarioNombreByNombreUsuario(String nombreUsuario) {
        Usuario query = this.usuarioRepository.findByNombreUsuario(nombreUsuario);
        String result = "";
        if( query != null ) {
            result = query.getNombre();
        }
        return result;
    }
}
