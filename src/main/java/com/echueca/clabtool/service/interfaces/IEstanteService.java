package com.echueca.clabtool.service;

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
    
    public ResponseEntity<?> saveEstante(Estante estante);
    
    public ResponseEntity<?> updateEstante(Estante estante);
    
    public ResponseEntity<?> deleteEstanteById(Long id);
}
