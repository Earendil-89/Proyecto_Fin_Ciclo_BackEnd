package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Etiqueta;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IEtiquetaService {
    
    /**
     *
     * @return
     */
    public List<Etiqueta> getEtiqueta();
    
    /**
     *
     * @param id
     * @return
     */
    public Etiqueta getEtiquetaById(Long id);
    
    /**
     *
     * @param etiqueta
     * @return
     */
    public ResponseEntity<?> saveEtiqueta(Etiqueta etiqueta);
    
    /**
     *
     * @param etiqueta
     * @return
     */
    public ResponseEntity<?> updateEtiqueta(Etiqueta etiqueta);
    
    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> deleteEtiqueta(Long id);
}
