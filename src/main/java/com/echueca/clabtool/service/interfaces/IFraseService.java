package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Frase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IFraseService {
    
    public List<Frase> getFrase();
    
    public Frase getFraseById(Long id);
    
    public ResponseEntity<?> saveFrase(Frase frase);
    
    public ResponseEntity<?> updateFrase(Frase frase);
    
    public ResponseEntity<?> deleteFrase(Long id);
}
