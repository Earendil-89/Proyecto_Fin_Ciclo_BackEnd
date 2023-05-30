package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.EnvaseResponseDTO;
import com.echueca.clabtool.DTO.EnvaseSearchDTO;
import com.echueca.clabtool.model.Envase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IEnvaseService {
    
    /**
     *
     * @return
     */
    public List<Envase> getEnvase();
    
    /**
     *
     * @param envase
     * @return
     */
    public List<EnvaseResponseDTO> getEnvaseAsUser(EnvaseSearchDTO envase);
    
    /**
     *
     * @param envase
     * @return
     */
    public ResponseEntity<?> saveEnvase(Envase envase);
    
    /**
     *
     * @param envase
     * @return
     */
    public ResponseEntity<?> updateEnvase(Envase envase);
    
    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> deleteEnvase(Long id);
}