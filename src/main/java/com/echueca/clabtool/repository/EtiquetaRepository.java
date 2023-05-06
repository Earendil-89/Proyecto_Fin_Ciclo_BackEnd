package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    
}