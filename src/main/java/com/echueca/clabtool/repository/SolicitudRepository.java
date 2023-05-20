package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Solicitud;
import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    
    List<Solicitud> findByEstadoContaining(String estado);
    
    List<Solicitud> findByEstadoNotContaining(String estado);
    
    List<Solicitud> findByusuarioSolicitud(Usuario usuarioSolicitud);
}
