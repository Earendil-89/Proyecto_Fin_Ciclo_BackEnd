package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IEstanteService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Armario;
import com.echueca.clabtool.model.Estante;
import com.echueca.clabtool.repository.ArmarioRepository;
import com.echueca.clabtool.repository.EstanteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class EstanteServiceImp implements IEstanteService {
    
    @Autowired
    private EstanteRepository estanteRepository;
    
    @Autowired
    private ArmarioRepository armarioRepository;

    @Override
    public List<Estante> getEstante() {
        return this.estanteRepository.findAll();
    }

    @Override
    public Estante getEstanteById(Long id) {
        return this.estanteRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<?> saveEstante(Estante estante) {
        Estante testEstante = estanteRepository.findByNombre(estante.getNombre());
        
        if( testEstante == null ) {
            this.estanteRepository.save(estante);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Estante creado corréctamente."));
        }
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El nombre de estante ya está en uso."));
    }

    @Override
    public ResponseEntity<?> updateEstante(Estante estante) {
        Estante testEstante = estanteRepository.findByNombre(estante.getNombre());
        
        if( testEstante != null && testEstante.getId() != estante.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El nombre de estante está en uso."));
        }
        
        this.estanteRepository.save(estante);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Estante actualizado corréctamente."));
    }

    @Override
    public ResponseEntity<?> deleteEstanteById(Long id) {
        this.estanteRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Estante borrado."));
    }
}