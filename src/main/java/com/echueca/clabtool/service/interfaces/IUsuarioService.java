package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IUsuarioService {
    
    /**
     *
     * @return
     */
    public List<Usuario> getUsuario();
    
    /**
     *
     * @param id
     * @return
     */
    public Usuario getUsuarioById(Long id);
    
    /**
     *
     * @param usuario
     * @return
     */
    public ResponseEntity<?> saveUsuario(Usuario usuario);
    
    /**
     *
     * @param usuario
     * @return
     */
    public ResponseEntity<?> updateUsuario(Usuario usuario);
    
    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> deleteUsuarioById(Long id);
    
    /**
     *
     * @param nombreUsuario
     * @return
     */
    public String getUsuarioNombreByNombreUsuario(String nombreUsuario);
}
