package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Solicitud;
import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para realizar CRUD de Solicitudes
 * @author Eduardo Chueca Montaner
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    
    /**
     * Busca solicitudes que contengan el estado indicado
     * @param estado Estado a incluir
     * @return Lista de solicitudes
     */
    List<Solicitud> findByEstadoContaining(String estado);
    
    /**
     * Busca solicitudes que no contengan el estado indicado
     * @param estado Estado a excluir
     * @return Lista de soilcitudes
     */
    List<Solicitud> findByEstadoNotContaining(String estado);
    
    /**
     * Busca solicitudes en funcion del usuario que las realizó
     * @param usuarioSolicitud Usuario que realizó la solicitud
     * @return Lista de solicitudes
     */
    List<Solicitud> findByusuarioSolicitud(Usuario usuarioSolicitud);
}
