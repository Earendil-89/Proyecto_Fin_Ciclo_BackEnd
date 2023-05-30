package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IFraseService;
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

    /**
     *
     * @return
     */
    @Override
    public List<Frase> getFrase() {
        return this.fraseRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Frase getFraseById(Long id) {
        return this.fraseRepository.findById(id).get();
    }

    /**
     *
     * @param frase
     * @return
     */
    @Override
    public ResponseEntity<?> saveFrase(Frase frase) {
        Frase testFrase = this.fraseRepository.findByCodigo(frase.getCodigo());
        
        if( testFrase == null ) {
            this.fraseRepository.save(frase);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase creada."));
        }
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El código de la frase ya está en uso."));
    }

    /**
     *
     * @param frase
     * @return
     */
    @Override
    public ResponseEntity<?> updateFrase(Frase frase) {
        Frase testFrase = this.fraseRepository.findByCodigo(frase.getCodigo());
        
        if( testFrase != null && testFrase.getId() != frase.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El código de la frase ya está en uso."));
        }
        
        this.fraseRepository.save(frase);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase creada."));
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<?> deleteFrase(Long id) {
        this.fraseRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase borrada."));
    }
}
