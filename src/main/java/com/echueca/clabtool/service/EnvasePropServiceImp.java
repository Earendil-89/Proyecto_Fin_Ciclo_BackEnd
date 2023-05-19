package com.echueca.clabtool.service;

import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.EnvaseProp;
import com.echueca.clabtool.repository.EnvasePropRepository;
import org.springframework.stereotype.Service;
import com.echueca.clabtool.service.interfaces.IEnvasePropService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class EnvasePropServiceImp implements IEnvasePropService {
    
    @Autowired
    private EnvasePropRepository envasePropRepository;

    @Override
    public List<EnvaseProp> getEnvaseProp() {
        return this.envasePropRepository.findAll();
    }

    @Override
    public EnvaseProp getEnvasePropById(Long id) {
        Optional<EnvaseProp> attemptEntity = this.envasePropRepository.findById(id);
        return attemptEntity.isPresent() ? attemptEntity.get() : null;
    }

    @Override
    public ResponseEntity<?> saveEnvaseProp(EnvaseProp envaseProp) {
        EnvaseProp testEntity = this.envasePropRepository.findByCodigo(envaseProp.getCodigo());
        if( testEntity == null ) {
            this.envasePropRepository.save(envaseProp);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Datos de envase creados"));
        }
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El código especificado ya existe"));
    }

    @Override
    public ResponseEntity<?> updateEnvaseProp(EnvaseProp envaseProp) {
        EnvaseProp testEntity = this.envasePropRepository.findByCodigo(envaseProp.getCodigo());
        if( testEntity != null && testEntity.getId() != envaseProp.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El código especificado ya está en uso"));
        }
        this.envasePropRepository.save(envaseProp);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Datos de envase actualizados"));
    }

    @Override
    public ResponseEntity<?> deleteEnvaseProp(Long id) {
        this.envasePropRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Datos de envase borrados"));
    }
}
