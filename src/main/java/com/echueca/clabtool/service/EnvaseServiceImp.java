package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IEnvaseService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.repository.EnvaseRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class EnvaseServiceImp implements IEnvaseService {
    
    private EnvaseRepository envaseRepository;

    @Override
    public List<Envase> getEnvase() {
        return this.envaseRepository.findAll();
    }

    @Override
    public ResponseEntity<?> saveEnvase(Envase envase) {
        this.envaseRepository.save(envase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase guardado"));
    }

    @Override
    public ResponseEntity<?> updateEnvase(Envase envase) {
        this.envaseRepository.save(envase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase actualizado"));
    }

    @Override
    public ResponseEntity<?> deleteEnvase(Long id) {
        this.envaseRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase borrado"));
    }
}
