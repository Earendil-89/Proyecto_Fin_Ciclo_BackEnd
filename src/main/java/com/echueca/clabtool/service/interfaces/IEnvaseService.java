package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.EnvaseReturnDTO;
import com.echueca.clabtool.DTO.EnvaseSearchDTO;
import com.echueca.clabtool.model.Envase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IEnvaseService {
    
    public List<Envase> getEnvase();
    
    public List<EnvaseReturnDTO> getEnvaseAsUser(EnvaseSearchDTO envase);
    
    public ResponseEntity<?> saveEnvase(Envase envase);
    
    public ResponseEntity<?> updateEnvase(Envase envase);
    
    public ResponseEntity<?> deleteEnvase(Long id);
}