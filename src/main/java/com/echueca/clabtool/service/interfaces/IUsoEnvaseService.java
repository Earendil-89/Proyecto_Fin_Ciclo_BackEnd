package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.UsoEnvase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IUsoEnvaseService {
    
    public List<UsoEnvase> getUsoEnvase();
    
    public List<UsoEnvase> getActiveUsoEnvase();
    
    public UsoEnvase getUsoEnvaseById(Long id);
    
    public List<UsoEnvase> getUsoEnvaseByUserId(Long id);
    
    public ResponseEntity<?> startUsoEnvase(Long id);
    
    public ResponseEntity<?> endUsoENvase(Long id);
    
    public ResponseEntity<?> saveUsoEnvase(Envase envase);
    
    public ResponseEntity<?> updateUsoEnvase(Envase envase);
    
    public ResponseEntity<?> deleteUsoEnvase(Envase envase);
}
