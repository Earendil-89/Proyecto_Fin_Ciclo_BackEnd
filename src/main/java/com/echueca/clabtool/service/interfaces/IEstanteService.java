package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Estante;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Interfaz que implementa los servicios de Estante
 * @author Eduardo Chueca Montaner
 */
public interface IEstanteService {
   
    /**
     * Busca todos los estantes almacenados en la base de datos
     * @return Lista con estantes
     */
    public List<Estante> getEstante();
    
    /**
     * Busca un estante por su ID
     * @param id ID del estante
     * @return Estante en caso satisfactorio, nulo en caso contrario
     */
    public Estante getEstanteById(Long id);
    
    /**
     * Busca un estante por el ID del armario al que pertenece
     * @param id ID del armario
     * @return Lista con estantes
     */
    public List<Estante> getEstanteByArmarioId(Long id);
    
    /**
     * Inserta un estante en la base de datos
     * @param estante Estante a insertar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveEstante(Estante estante);
    
    /**
     * Actualiza un estante existente en la base de datos
     * @param estante Estante a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updateEstante(Estante estante);
    
    /**
     * Elimina un estante de la base de datos
     * @param id ID del envase a eliminar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteEstante(Long id);
}
