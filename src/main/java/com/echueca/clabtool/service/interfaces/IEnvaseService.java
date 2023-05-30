package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.EnvaseResponseDTO;
import com.echueca.clabtool.DTO.EnvaseSearchDTO;
import com.echueca.clabtool.model.Envase;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Interfaz que implementa los servicios de Envase
 * @author Eduardo Chueca Montaner
 */
public interface IEnvaseService {
    
    /**
     * Devuelve todos los envases almacenados en la base de datos
     * @return Lista de envases
     */
    public List<Envase> getEnvase();
    
    /**
     * Devuelve el resultado de una consulta con datos limitados
     * @param envase Objeto DTO para buscar envase
     * @return Objeto DTO con datos de envase limitados
     */
    public List<EnvaseResponseDTO> getEnvaseAsUser(EnvaseSearchDTO envase);
    
    /**
     * Inserta un nuevo envase en la base de datos
     * @param envase Envase a insertar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveEnvase(Envase envase);
    
    /**
     * Actualiza un envase existente en la base de datos
     * @param envase Envase a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updateEnvase(Envase envase);
    
    /**
     * Elimina un envase de la base de datos
     * @param id ID del envase
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteEnvase(Long id);
}