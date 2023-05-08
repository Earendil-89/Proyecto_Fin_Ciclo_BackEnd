package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.EnvaseProp;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IEnvasePropService {
    
    public List<EnvaseProp> getEnvaseProp();
    
    public EnvaseProp getEnvasePropById(Long id);
    
    public ResponseEntity<?> saveEnvaseProp(EnvaseProp envaseProp);
    
    public ResponseEntity<?> updateEnvaseProp(EnvaseProp envaseProp);
    
    public ResponseEntity<?> deleteEnvaseProp(Long id);
}