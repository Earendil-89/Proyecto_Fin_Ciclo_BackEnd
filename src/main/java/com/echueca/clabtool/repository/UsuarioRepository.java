package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface UsuarioRepository extends CrudRepository<Usuario, String> {
    
}
