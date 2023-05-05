package com.echueca.clabtool.service;

import com.echueca.clabtool.model.Etiqueta;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IEtiquetaService {
    
    public List<Etiqueta> getEtiqueta();
    
    public Etiqueta getEtiquetaById(String id);
    
    public ResponseEntity<?> saveEtiqueta(Etiqueta etiqueta);
    
    public ResponseEntity<?> updateEtiqueta(Etiqueta etiqueta);
    
    public ResponseEntity<?> deleteEtiqueta(String id);
}
