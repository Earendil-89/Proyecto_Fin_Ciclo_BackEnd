package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IEtiquetaService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Etiqueta;
import com.echueca.clabtool.repository.EtiquetaRepository;
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
public class EtiquetaServiceImp implements IEtiquetaService {
    
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    /**
     *
     * @return
     */
    @Override
    public List<Etiqueta> getEtiqueta() {
        return this.etiquetaRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Etiqueta getEtiquetaById(Long id) {
        return this.etiquetaRepository.findById(id).get();
    }

    /**
     *
     * @param etiqueta
     * @return
     */
    @Override
    public ResponseEntity<?> saveEtiqueta(Etiqueta etiqueta) {
        Etiqueta testEntity = this.etiquetaRepository.findByCodigo(etiqueta.getCodigo());
        
        if( testEntity == null ) {
            this.etiquetaRepository.save(etiqueta);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta creada."));          
        }
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El codigo de la etiqueta ya existe."));
    }

    /**
     *
     * @param etiqueta
     * @return
     */
    @Override
    public ResponseEntity<?> updateEtiqueta(Etiqueta etiqueta) {
        Etiqueta testEntity = this.etiquetaRepository.findByCodigo(etiqueta.getCodigo());
        
        if( testEntity != null && testEntity.getId() != etiqueta.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El codigo está en uso por otra etiqueta."));
        }

        this.etiquetaRepository.save(etiqueta);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta actualizada."));
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<?> deleteEtiqueta(Long id) {
        this.etiquetaRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta eliminada."));
    }
}
