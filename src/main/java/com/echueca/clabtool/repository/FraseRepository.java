package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface FraseRepository extends JpaRepository<Frase, Long> {
    
    public Frase findByCodigo(String codigo);
}
