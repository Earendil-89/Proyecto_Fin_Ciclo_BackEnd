package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IEtiquetaService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Etiqueta;
import com.echueca.clabtool.repository.EtiquetaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class EtiquetaServiceImp implements IEtiquetaService {
    
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public List<Etiqueta> getEtiqueta() {
        return this.etiquetaRepository.findAll();
    }

    @Override
    public Etiqueta getEtiquetaById(Long id) {
        return this.etiquetaRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<?> saveEtiqueta(Etiqueta etiqueta) {
        Etiqueta testEtiqueta = this.etiquetaRepository.findById(etiqueta.getId()).get();
        
        if( testEtiqueta == null ) {
            this.etiquetaRepository.save(etiqueta);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta creada."));
        }
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El codigo de la etiqueta ya existe."));
    }

    @Override
    public ResponseEntity<?> updateEtiqueta(Etiqueta etiqueta) {
        Etiqueta testEtiqueta = this.etiquetaRepository.findById(etiqueta.getId()).get();
        
        if( testEtiqueta != null && testEtiqueta.getId() != etiqueta.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El codigo está en uso por otra etiqueta."));
        }

        this.etiquetaRepository.save(etiqueta);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta actualizada."));
    }

    @Override
    public ResponseEntity<?> deleteEtiqueta(Long id) {
        this.etiquetaRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta eliminada."));
    }
}
