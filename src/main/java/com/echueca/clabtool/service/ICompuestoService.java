package com.echueca.clabtool.service;

import com.echueca.clabtool.model.Compuesto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface ICompuestoService {
    
    public List<Compuesto> getCompuesto();
    
    public Compuesto getCompuestoById(String id);
    
    public ResponseEntity<?> saveCompuesto(Compuesto compuesto);
    
    public ResponseEntity<?> updateCompuesto(Compuesto compuesto);
    
    public ResponseEntity<?> deleteCompuesto(String id);
}
