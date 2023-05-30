package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Frase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IFraseService {
    
    /**
     *
     * @return
     */
    public List<Frase> getFrase();
    
    /**
     *
     * @param id
     * @return
     */
    public Frase getFraseById(Long id);
    
    /**
     *
     * @param frase
     * @return
     */
    public ResponseEntity<?> saveFrase(Frase frase);
    
    /**
     *
     * @param frase
     * @return
     */
    public ResponseEntity<?> updateFrase(Frase frase);
    
    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> deleteFrase(Long id);
}
