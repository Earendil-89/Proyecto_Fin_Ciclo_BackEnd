package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Estante;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface EstanteRepository extends JpaRepository<Estante, Long> {
    
    public Estante findByNombre(String nombre);
}
