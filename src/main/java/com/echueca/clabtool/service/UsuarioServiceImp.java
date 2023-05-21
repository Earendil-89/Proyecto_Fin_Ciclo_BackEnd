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
    
    @Override
    public List<Usuario> getUsuario() {
        return this.usuarioRepository.findAll();
    }
    
    @Override
    public Usuario getUsuarioById(Long id) { 
        return this.usuarioRepository.findById(id).get();
    }

    @Override
    public String getUsuarioNombreByNombreUsuario(String nombreUsuario) {
        Usuario query = this.usuarioRepository.findByNombreUsuario(nombreUsuario);
        String result = "";
        if( query != null ) {
            result = query.getNombre();
        }
        return result;
    }
    
    @Override
    public ResponseEntity<?> saveUsuario(Usuario usuario) {
        Usuario userTest = this.usuarioRepository.findByEmail(usuario.getEmail());
        if( userTest != null ) {
                return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El email ya esta en uso por otro usuario."));
        }
        
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Usuario creado."));
    }
    
    @Override
    public ResponseEntity<?> updateUsuario(Usuario usuario) {
        Usuario userTest = this.usuarioRepository.findByEmail(usuario.getEmail());
        if( userTest != null && userTest.getId() != usuario.getId() )  {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El email ya esta en uso por otro usuario."));
        }
            
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Usuario actualizado."));
    }
    
    @Override
    public ResponseEntity<?> deleteUsuarioById(Long id ){
        this.usuarioRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Usuario borrado"));
    }
}
