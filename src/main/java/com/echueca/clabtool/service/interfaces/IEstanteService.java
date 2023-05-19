package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Estante;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IEstanteService {
   
    public List<Estante> getEstante();
    
    public Estante getEstanteById(Long id);
    
    public List<Estante> getEstanteByArmarioId(Long id);
    
    public ResponseEntity<?> saveEstante(Estante estante);
    
    public ResponseEntity<?> updateEstante(Estante estante);
    
    public ResponseEntity<?> deleteEstante(Long id);
}
