package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.SolicitudCreateDTO;
import com.echueca.clabtool.DTO.SolicitudProcessDTO;
import com.echueca.clabtool.model.Solicitud;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Interfaz que implementa los servicios de Solicitud
 * @author Eduardo Chueca Montaner
 */
public interface ISolicitudService {
    
    /**
     * Busca todas las solicitudes en la base de datos
     * @return Lista con las solicitudes
     */
    public List<Solicitud> getSolicitud();
    
    /**
     * Busca una solicitud por su ID
     * @param id ID de la solicitud a buscar
     * @return Solicitud en caso satisfactorio, nulo en caso contrario
     */
    public Solicitud getSolicitudById(Long id);
    
    /**
     * Busca todas las solicitudes realizadas por un usuario
     * @param nombreUsuario Nombre del usuario que ha reazliado la solicitud
     * @return Lista con solicitudes
     */
    public List<Solicitud> getSolicitudByNombreUsuario(String nombreUsuario);
    
    /**
     * Busca todas las solicitudes activas, o no tramitadas
     * @return Lista con solicitudes activas
     */
    public List<Solicitud> getActiveSolicitud();
    
    /**
     * Busca todas las solicitudes inactivas, o tramitadas
     * @return Lista con solicitudes inactivas
     */
    public List<Solicitud> getInactiveSolicitud();
    
    /**
     * Busca todas las solicitudes realizadas por un usuario
     * @param id ID del usuario que ha realizado la solicitud
     * @return Lista con solicitudes
     */
    public List<Solicitud> getSolicitudByUsuarioId(Long id);
    
    /**
     * Inserta una nueva solicitud en la base de datos
     * @param solicitud Solicitud a insertar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveSolicitud(Solicitud solicitud);
    
    /**
     * Actualiza una soliciutd existente en la base de datos
     * @param solicitud Solicitud a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updateSolicitud(Solicitud solicitud);
    
    /**
     * Procesa una solicitud y cambia su estado de tramitacion
     * @param solicitud Proceso a insertar
     * @param nombreUsuario Nombre del usuario que procesa la solicitud
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> processSolicitud(SolicitudProcessDTO solicitud, String nombreUsuario);
    
    /**
     * Crea una nueva solicitud con un usuario
     * @param solicitud Datos de la solicitud a crear
     * @param nombreUsuario Nombre del usuario que ha creado la solicitud
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveSolicitudByUsuario(SolicitudCreateDTO solicitud, String nombreUsuario);
    
    /**
     * Elimina una solicitud de la base de datos
     * @param id ID de la solicitud a eliminar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteSolicitud(Long id);
}
