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
 * Clase que implementa la interfaz IFraseService
 * @author Eduardo Chueca Montaner
 */
@Service
public class FraseServiceImp implements IFraseService {
    
    @Autowired
    private FraseRepository fraseRepository;

    /**
     * Busca todas las frases en la base de datos
     * @return Lista con las frases
     */
    @Override
    public List<Frase> getFrase() {
        return this.fraseRepository.findAll();
    }

    /**
     * Busca una frase por su ID
     * @param id ID de la frase
     * @return Frase en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public Frase getFraseById(Long id) {
        return this.fraseRepository.findById(id).get();
    }

    /**
     * Inserta una frase en la base de datos
     * @param frase Frase a insertar
     * @return Mensaje de respuesta
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
     * Actualiza una frase en la base de datos
     * @param frase Frase a actualizar
     * @return Mensaje de respuesta
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
     * Elimina una frase en la base de datos
     * @param id ID de la frase a eliminar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteFrase(Long id) {
        this.fraseRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Frase borrada."));
    }
}
