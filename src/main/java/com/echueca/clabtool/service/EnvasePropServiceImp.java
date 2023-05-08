package com.echueca.clabtool.service;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<?> updateEnvaseProp(EnvaseProp envaseProp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<?> deleteEnvaseProp(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
