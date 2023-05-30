package com.echueca.clabtool.service;

import com.echueca.clabtool.DTO.SolicitudCreateDTO;
import com.echueca.clabtool.DTO.SolicitudProcessDTO;
import com.echueca.clabtool.service.interfaces.ISolicitudService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Solicitud;
import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.repository.SolicitudRepository;
import com.echueca.clabtool.repository.UsuarioRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz ISolicitudService
 * @author Eduardo Chueca Montaner
 */
@Service
public class SolicitudServiceImp implements ISolicitudService {
    
    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Busca todas las solicitudes en la base de datos
     * @return Lista con las solicitudes
     */
    @Override
    public List<Solicitud> getSolicitud() {
        return this.solicitudRepository.findAll();
    }

    /**
     * Busca una solicitud por su ID
     * @param id ID de la solicitud a buscar
     * @return Solicitud en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public Solicitud getSolicitudById(Long id) {
        return this.solicitudRepository.findById(id).get();
    }
    
    /**
     * Busca todas las solicitudes realizadas por un usuario
     * @param nombreUsuario Nombre del usuario que ha reazliado la solicitud
     * @return Lista con solicitudes
     */
    @Override
    public List<Solicitud> getSolicitudByNombreUsuario(String nombreUsuario) {
        Usuario user = this.usuarioRepository.findByNombreUsuario(nombreUsuario);
        return this.solicitudRepository.findByusuarioSolicitud(user);
    }
    
    /**
     * Busca todas las solicitudes activas, o no tramitadas
     * @return Lista con solicitudes activas
     */
    @Override
    public List<Solicitud> getActiveSolicitud() {
        return this.solicitudRepository.findByEstadoContaining("ESTADO_ESPERA");
    }

    /**
     * Busca todas las solicitudes inactivas, o tramitadas
     * @return Lista con solicitudes inactivas
     */
    @Override
    public List<Solicitud> getInactiveSolicitud() {
        return this.solicitudRepository.findByEstadoNotContaining("ESTADO_ESPERA");
    }

    /**
     * Busca todas las solicitudes realizadas por un usuario
     * @param id ID del usuario que ha realizado la solicitud
     * @return Lista con solicitudes
     */
    @Override
    public List<Solicitud> getSolicitudByUsuarioId(Long id) {
        Optional<Usuario> testEntity = this.usuarioRepository.findById(id);
        if( testEntity.isEmpty() ) {
            return null;
        }
        return this.solicitudRepository.findByusuarioSolicitud(testEntity.get());
    }
    
    /**
     * Inserta una nueva solicitud en la base de datos
     * @param solicitud Solicitud a insertar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveSolicitud(Solicitud solicitud) {
        this.solicitudRepository.save(solicitud);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud creada"));
    }

    /**
     * Actualiza una soliciutd existente en la base de datos
     * @param solicitud Solicitud a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateSolicitud(Solicitud solicitud) {
        this.solicitudRepository.save(solicitud);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud actualizada."));
    }
    
    /**
     * Procesa una solicitud y cambia su estado de tramitacion
     * @param solicitud Proceso a insertar
     * @param nombreUsuario Nombre del usuario que procesa la solicitud
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> processSolicitud(SolicitudProcessDTO solicitud, String nombreUsuario) {
        Usuario user = this.usuarioRepository.findByNombreUsuario(nombreUsuario);
        if( user == null ) {
            String msg = "No se encuentra el usuario con el nombre \"" + nombreUsuario +"\"";
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, msg));
        }
        Optional<Solicitud> attempt = solicitudRepository.findById(solicitud.getId());
        if( attempt.isEmpty() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "No se encuentra la solicitud en la base de datos."));
        }
        Solicitud update = attempt.get();
        update.setUsuarioTramite(user);
        update.setFechaTramite(new Date());
        update.setEstado(solicitud.getEstado());
        this.solicitudRepository.save(update);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud tramitada."));
    }

    /**
     * Crea una nueva solicitud con un usuario
     * @param solicitud Datos de la solicitud a crear
     * @param nombreUsuario Nombre del usuario que ha creado la solicitud
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveSolicitudByUsuario(SolicitudCreateDTO solicitud, String nombreUsuario) {
        Usuario user = this.usuarioRepository.findByNombreUsuario(nombreUsuario);
        if( user == null ) {
            String msg = "No se encuentra el usuario con el nombre \"" + nombreUsuario +"\"";
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, msg));
        }
        Solicitud insert = new Solicitud(solicitud);
        insert.setUsuarioSolicitud(user);
        this.solicitudRepository.save(insert);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud creada"));
    }

    /**
     * Elimina una solicitud de la base de datos
     * @param id ID de la solicitud a eliminar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteSolicitud(Long id) {
        this.solicitudRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud borrada."));
    }
}
