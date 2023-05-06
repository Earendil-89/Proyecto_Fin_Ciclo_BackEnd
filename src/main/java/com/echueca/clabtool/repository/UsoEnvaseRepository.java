package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.UsoEnvase;
import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface UsoEnvaseRepository extends JpaRepository<UsoEnvase, Long> {
    
    public List<UsoEnvase> findByFechaDevolucionNotNull();
    
    public List<UsoEnvase> findByUsuario(Usuario usuario);
}
