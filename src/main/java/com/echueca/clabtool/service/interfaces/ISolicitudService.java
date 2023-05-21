package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.SolicitudDTO;
import com.echueca.clabtool.model.Solicitud;
import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface ISolicitudService {
    
    public List<Solicitud> getSolicitud();
    
    public List<Solicitud> getSolicitudByNombreUsuario(String nombreusuario);
    
    public List<Solicitud> getActiveSolicitud();
    
    public List<Solicitud> getInactiveSolicitud();
    
    public List<Solicitud> getSolicitudByUsuarioId(Long id);
    
    public Solicitud getSolicitudById(Long id);
    
    public ResponseEntity<?> saveSolicitud(Solicitud solicitud);
    
    public ResponseEntity<?> updateSolicitud(Solicitud solicitud);
    
    public ResponseEntity<?> saveSolicitudByUsuario(SolicitudDTO solicitud, String nombreUsuario);
    
    public ResponseEntity<?> updateSolicitudByUsuario(SolicitudDTO solicitud, String nombreUsuario);
    
    public ResponseEntity<?> deleteSolicitud(Long id);
}
