package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.EnvaseProp;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Objeto que desarrolla los serivicos de EnvaseProp
 * @author Eduardo Chueca Montaner
 */
public interface IEnvasePropService {
    
    /**
     * Busca todas las propiedades de envases de la base de datos
     * @return Lista con propiedades de envases
     */
    public List<EnvaseProp> getEnvaseProp();
    
    /**
     * Busca una propiedad de envases por su ID
     * @param id ID de la propiedad de envases a buscar
     * @return EnvaseProp en caso satisfactorio, nulo en caso contrario
     */
    public EnvaseProp getEnvasePropById(Long id);
    
    /**
     * Inserta una nueva propiedad de envases en la base de datos
     * @param envaseProp Propiedad de envases a insertar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveEnvaseProp(EnvaseProp envaseProp);
    
    /**
     * Actualiza una propiedad de envases existente en la base de datos
     * @param envaseProp Propiedad de envases a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updateEnvaseProp(EnvaseProp envaseProp);
    
    /**
     * Elimina una propiedad de envases de la base de datos
     * @param id ID de la propiedad de envases a eliminar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteEnvaseProp(Long id);
}