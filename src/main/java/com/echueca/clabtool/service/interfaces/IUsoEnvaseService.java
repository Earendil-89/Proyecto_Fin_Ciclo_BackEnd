package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.EnvaseExtractDTO;
import com.echueca.clabtool.model.UsoEnvase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Interfaz que implementa los servicios de UsoEnvase
 * @author Eduardo Chueca Montaner
 */
public interface IUsoEnvaseService {
    
    /**
     * Busca todos los usos de envases en la base de datos
     * @return Lista con los usos de envase
     */
    public List<UsoEnvase> getUsoEnvase();
    
    /**
     * Busca todos los usos de envase activos 
     * @return Lista con usos de envase
     */
    public List<UsoEnvase> getActiveUsoEnvase();
    
    /**
     * Busca un uso de envase por su ID
     * @param id ID del uso de envase
     * @return UsoEnvase en caso satisfactorio, nulo en caso contrario
     */
    public UsoEnvase getUsoEnvaseById(Long id);
    
    /**
     * Busca todos los usos de envase por el id de un usuario
     * @param id ID del usuario
     * @return Lista con usos de envase
     */
    public List<UsoEnvase> getUsoEnvaseByUserId(Long id);
        
    /**
     * Busca todos los usos de envase activos por usuario
     * @param nombreUsuario Nombre del usuario
     * @return Lista con unosos de envase
     */
    public List<UsoEnvase> getActiveUsoEnvaseByNombreUsuario(String nombreUsuario);
    
    /**
     * Crea un nuevo uso de envase en la base de datos como una extraccion de envase
     * @param extr Datos de la extraccion
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveUsoEnvase(EnvaseExtractDTO extr);
    
    /**
     * Actualiza un uso de envase presente en la base de datos
     * @param usoEnvase Uso de envase a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updateUsoEnvase(UsoEnvase usoEnvase);
    
    /**
     * Elimina un uso de envase de la base de datos
     * @param id ID del uso de envase
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteUsoEnvase(Long id);
}
