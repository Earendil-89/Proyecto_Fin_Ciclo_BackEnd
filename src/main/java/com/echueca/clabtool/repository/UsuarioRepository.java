package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Realiza consultas a la base de datos para realizar CRUD de usuarios
 * @author Eduardo Chueca Montaner
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    /**
     * Busca usuarios por email (coincidencia exacta)
     * @param email Email a buscar
     * @return Usuario en caso satisfactorio, nulo en caso contrario
     */
    public Usuario findByEmail(String email);
    
    /**
     * DBusca usuarios por su nombre de usuario (coincidencia exacta)
     * @param nombreUsuario Nombre de usuario a buscar
     * @return Usuario en caso satisfactorio, nulo en caso contrario
     */
    public Usuario findByNombreUsuario(String nombreUsuario);
}
