package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.ICompuestoService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.repository.CompuestoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class CompuestoServiceImp implements ICompuestoService {
    
    @Autowired
    private CompuestoRepository compuestoRepository;

    @Override
    public List<Compuesto> getCompuesto() {
        return this.compuestoRepository.findAll();
    }

    @Override
    public Compuesto getCompuestoById(Long id) {
        return this.compuestoRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<?> saveCompuesto(Compuesto compuesto) {
        Compuesto testCompuesto = this.compuestoRepository.findById(compuesto.getId()).get();
        
        if( testCompuesto == null ) {
            this.compuestoRepository.save(compuesto);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Compuesto químico creado."));
        }
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El número CAS ya está registrado."));
    }

    @Override
    public ResponseEntity<?> updateCompuesto(Compuesto compuesto) {
        Compuesto testCompuesto = this.compuestoRepository.findById(compuesto.getId()).get();
        
        if( testCompuesto == null || testCompuesto.getId() == compuesto.getId()) {
            this.compuestoRepository.save(compuesto);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Compuesto químico actualizado."));
        }
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El número CAS está en uso por otro compuesto."));
    }

    @Override
    public ResponseEntity<?> deleteCompuesto(Long id) {
        this.compuestoRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Compuesto químico borrado."));
    }
}
