package com.echueca.clabtool.service;

import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Frase;
import com.echueca.clabtool.repository.FraseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class FraseServiceImp implements IFraseService {
    
    @Autowired
    private FraseRepository fraseRepository;

    @Override
    public List<Frase> getFrase() {
        return this.fraseRepository.findAll();
    }

    @Override
    public Frase getFraseById(Long id) {
        return this.fraseRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<?> saveFrase(Frase frase) {
        Frase testFrase = this.fraseRepository.findByCodigo(frase.getCodigo());
        
        if( testFrase == null ) {
            this.fraseRepository.save(frase);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase creada."));
        }
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El código de la frase ya está en uso."));
    }

    @Override
    public ResponseEntity<?> updateFrase(Frase frase) {
        Frase testFrase = this.fraseRepository.findByCodigo(frase.getCodigo());
        
        if( testFrase != null && testFrase.getId() != frase.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El código de la frase ya está en uso."));
        }
        
        this.fraseRepository.save(frase);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase creada."));
    }

    @Override
    public ResponseEntity<?> deleteFrase(Long id) {
        this.fraseRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase borrada."));
    }
}
