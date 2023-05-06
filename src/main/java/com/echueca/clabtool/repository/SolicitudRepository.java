package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    
}
