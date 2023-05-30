package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.SolicitudCreateDTO;
import com.echueca.clabtool.DTO.SolicitudProcessDTO;
import com.echueca.clabtool.model.Solicitud;
import com.echueca.clabtool.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface ISolicitudService {
    
    /**
     *
     * @return
     */
    public List<Solicitud> getSolicitud();
    
    /**
     *
     * @param nombreusuario
     * @return
     */
    public List<Solicitud> getSolicitudByNombreUsuario(String nombreusuario);
    
    /**
     *
     * @return
     */
    public List<Solicitud> getActiveSolicitud();
    
    /**
     *
     * @return
     */
    public List<Solicitud> getInactiveSolicitud();
    
    /**
     *
     * @param id
     * @return
     */
    public List<Solicitud> getSolicitudByUsuarioId(Long id);
    
    /**
     *
     * @param id
     * @return
     */
    public Solicitud getSolicitudById(Long id);
    
    /**
     *
     * @param solicitud
     * @return
     */
    public ResponseEntity<?> saveSolicitud(Solicitud solicitud);
    
    /**
     *
     * @param solicitud
     * @return
     */
    public ResponseEntity<?> updateSolicitud(Solicitud solicitud);
    
    /**
     *
     * @param solicitud
     * @param nombreUsuario
     * @return
     */
    public ResponseEntity<?> processSolicitud(SolicitudProcessDTO solicitud, String nombreUsuario);
    
    /**
     *
     * @param solicitud
     * @param nombreUsuario
     * @return
     */
    public ResponseEntity<?> saveSolicitudByUsuario(SolicitudCreateDTO solicitud, String nombreUsuario);
    
    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> deleteSolicitud(Long id);
}
