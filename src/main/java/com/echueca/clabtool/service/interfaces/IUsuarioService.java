package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Interfaz que implementa los servicios de Usuario
 * @author Eduardo Chueca Montaner
 */
public interface IUsuarioService {
    
    /**
     * Busca todos los usuarios de la base de datos
     * @return Lista con los usuarios
     */
    public List<Usuario> getUsuario();
    
    /**
     * Busca un usuario por su ID
     * @param id ID del usuario
     * @return Usuario en caso satisfactorio, nulo en caso contrario
     */
    public Usuario getUsuarioById(Long id);
    
    /**
     * Inserta un nuevo usuario en la base de datos
     * @param usuario Usuario a insertar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveUsuario(Usuario usuario);
    
    /**
     * Actualiza un usuario existente en la base de datos
     * @param usuario Usuario a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updateUsuario(Usuario usuario);
    
    /**
     * Elimina un usuario de la base de datos
     * @param id ID del usuario a eliminar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteUsuarioById(Long id);
    
    /**
     * Devuelve el nombre real de un usuario a partir de su nombre de usuario
     * @param nombreUsuario Nombre de usuario a buscar
     * @return Nombre del usuario
     */
    public String getUsuarioNombreByNombreUsuario(String nombreUsuario);
}
