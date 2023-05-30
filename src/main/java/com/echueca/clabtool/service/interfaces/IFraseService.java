package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Frase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Interfaz que implementa los servicios de Frase
 * @author Eduardo Chueca Montaner
 */
public interface IFraseService {
    
    /**
     * Busca todas las frases en la base de datos
     * @return Lista con todas las frases
     */
    public List<Frase> getFrase();
    
    /**
     * Busca una frase por su ID
     * @param id ID de la frase a buscar
     * @return Frase en caso satisfactorio, nulo en caso contrario
     */
    public Frase getFraseById(Long id);
    
    /**
     * Inserta una frase en la base de datos
     * @param frase Frase a insertar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveFrase(Frase frase);
    
    /**
     * Actualiza una frase existente en la base de datos
     * @param frase Frase a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updateFrase(Frase frase);
    
    /**
     * Elimina una frase existente en la base de datos
     * @param id ID de la frase a borrar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteFrase(Long id);
}
