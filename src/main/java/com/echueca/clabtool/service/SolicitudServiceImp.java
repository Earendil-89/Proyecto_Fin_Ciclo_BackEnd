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
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class SolicitudServiceImp implements ISolicitudService {
    
    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Solicitud> getSolicitud() {
        return this.solicitudRepository.findAll();
    }

    @Override
    public Solicitud getSolicitudById(Long id) {
        return this.solicitudRepository.findById(id).get();
    }
    
    @Override
    public List<Solicitud> getSolicitudByNombreUsuario(String nombreUsuario) {
        Usuario user = this.usuarioRepository.findByNombreUsuario(nombreUsuario);
        return this.solicitudRepository.findByusuarioSolicitud(user);
    }
    
    @Override
    public List<Solicitud> getActiveSolicitud() {
        return this.solicitudRepository.findByEstadoContaining("ESTADO_ESPERA");
    }

    @Override
    public List<Solicitud> getInactiveSolicitud() {
        return this.solicitudRepository.findByEstadoNotContaining("ESTADO_ESPERA");
    }

    @Override
    public List<Solicitud> getSolicitudByUsuarioId(Long id) {
        Optional<Usuario> testEntity = this.usuarioRepository.findById(id);
        if( testEntity.isEmpty() ) {
            return null;
        }
        return this.solicitudRepository.findByusuarioSolicitud(testEntity.get());
    }
    
    @Override
    public ResponseEntity<?> saveSolicitud(Solicitud solicitud) {
        this.solicitudRepository.save(solicitud);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud creada"));
    }

    @Override
    public ResponseEntity<?> updateSolicitud(Solicitud solicitud) {
        this.solicitudRepository.save(solicitud);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud actualizada."));
    }
    
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


    @Override
    public ResponseEntity<?> deleteSolicitud(Long id) {
        this.solicitudRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud borrada."));
    }
}
