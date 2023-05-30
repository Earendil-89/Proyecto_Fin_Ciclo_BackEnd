package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Estante;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IEstanteService {
   
    /**
     *
     * @return
     */
    public List<Estante> getEstante();
    
    /**
     *
     * @param id
     * @return
     */
    public Estante getEstanteById(Long id);
    
    /**
     *
     * @param id
     * @return
     */
    public List<Estante> getEstanteByArmarioId(Long id);
    
    /**
     *
     * @param estante
     * @return
     */
    public ResponseEntity<?> saveEstante(Estante estante);
    
    /**
     *
     * @param estante
     * @return
     */
    public ResponseEntity<?> updateEstante(Estante estante);
    
    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> deleteEstante(Long id);
}
