package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IUsuarioService {
    
    public List<Usuario> getUsuario();
    
    public Usuario getUsuarioById(Long id);
    
    public ResponseEntity<?> saveUsuario(Usuario usuario);
    
    public ResponseEntity<?> updateUsuario(Usuario usuario);
    
    public ResponseEntity<?> deleteUsuarioById(Long id);
}
