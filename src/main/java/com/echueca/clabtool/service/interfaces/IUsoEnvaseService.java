package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.EnvaseExtractDTO;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.UsoEnvase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IUsoEnvaseService {
    
    /**
     *
     * @return
     */
    public List<UsoEnvase> getUsoEnvase();
    
    /**
     *
     * @return
     */
    public List<UsoEnvase> getActiveUsoEnvase();
    
    /**
     *
     * @param nombreUsuario
     * @return
     */
    public List<UsoEnvase> getActiveUsoEnvaseByNombreUsuario(String nombreUsuario);
    
    /**
     *
     * @param id
     * @return
     */
    public UsoEnvase getUsoEnvaseById(Long id);
    
    /**
     *
     * @param id
     * @return
     */
    public List<UsoEnvase> getUsoEnvaseByUserId(Long id);
    
    /**
     *
     * @param extr
     * @return
     */
    public ResponseEntity<?> saveUsoEnvase(EnvaseExtractDTO extr);
    
    /**
     *
     * @param usoEnvase
     * @return
     */
    public ResponseEntity<?> updateUsoEnvase(UsoEnvase usoEnvase);
    
    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> deleteUsoEnvase(Long id);
}
