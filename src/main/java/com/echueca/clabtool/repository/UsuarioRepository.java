package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public Usuario getUsuarioByEmail(String email);
}
