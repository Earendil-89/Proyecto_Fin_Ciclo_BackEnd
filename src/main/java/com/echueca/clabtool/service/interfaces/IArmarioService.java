package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Armario;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IArmarioService {
    
    public List<Armario> getArmario();
    
    public Armario getArmarioById(Long id);
    
    public ResponseEntity<?> saveArmario(Armario armario);
    
    public ResponseEntity<?> updateArmario(Armario armario);
    
    public ResponseEntity<?> deleteArmario(Long id);
}
