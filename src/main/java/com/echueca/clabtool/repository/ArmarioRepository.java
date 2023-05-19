package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Armario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface ArmarioRepository extends JpaRepository<Armario, Long> {
    
    public Armario findByNombre(String nombre);
}
