package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.ISolicitudService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Solicitud;
import com.echueca.clabtool.repository.SolicitudRepository;
import java.util.List;
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

    @Override
    public List<Solicitud> getSolicitud() {
        return this.solicitudRepository.findAll();
    }

    @Override
    public Solicitud getSolicitudById(Long id) {
        return this.solicitudRepository.findById(id).get();
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
    public ResponseEntity<?> deleteSolicitud(Long id) {
        this.solicitudRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Solicitud borrada."));
    }
}
