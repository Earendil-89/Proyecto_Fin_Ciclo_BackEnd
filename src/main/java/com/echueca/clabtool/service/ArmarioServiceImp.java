package com.echueca.clabtool.service;

import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Armario;
import com.echueca.clabtool.repository.ArmarioRepository;
import com.echueca.clabtool.service.interfaces.IArmarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class ArmarioServiceImp implements IArmarioService {
    
    @Autowired
    private ArmarioRepository armarioRepository;
    
    @Override
    public List<Armario> getArmario() {
        return this.armarioRepository.findAll();
    }

    @Override
    public Armario getArmarioById(Long id) {
        return this.armarioRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<?> saveArmario(Armario armario) {
        Armario testEntity = this.armarioRepository.findByNombre(armario.getNombre());
        
        if( testEntity == null ) {
            this.armarioRepository.save(armario);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Armario creado."));
        }
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El nombre de armario ya está en uso"));
    }

    @Override
    public ResponseEntity<?> updateArmario(Armario armario) {
        Armario testEntity = this.armarioRepository.findByNombre(armario.getNombre());
        
        if( testEntity != null && testEntity.getId() != armario.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El nombre de armario ya está en uso"));
        }
        
        this.armarioRepository.save(armario);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Armario actualizado."));      
    }

    @Override
    public ResponseEntity<?> deleteArmario(Long id) {
        this.armarioRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Armario eliminado."));
    }
}
