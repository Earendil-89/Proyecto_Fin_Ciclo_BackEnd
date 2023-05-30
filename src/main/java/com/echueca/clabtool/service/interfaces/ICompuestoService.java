package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Compuesto;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Interfaz que implementa los servicios de Compuesto
 * @author Eduardo Chueca Montaner
 */
public interface ICompuestoService {
    
    /**
     * Consulta todos los compuestos químicos de la base de datos
     * @return Lista con todos los compuestos
     */
    public List<Compuesto> getCompuesto();
    
    /**
     * Busca un compuesto químico por su ID
     * @param id ID del compuesto químico
     * @return Compuesto en caso satisfactorio, nulo en caso contrario
     */
    public Compuesto getCompuestoById(Long id);
    
    /**
     * Inserta un nuevo compuesto en la base de datos
     * @param compuesto Compuesto a insertar
     * @return mensaje de respuesta
     */
    public ResponseEntity<?> saveCompuesto(Compuesto compuesto);
    
    /**
     * Actualiza un compuesto en la base de datos
     * @param compuesto Compuesto a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updateCompuesto(Compuesto compuesto);
    
    /**
     * Borra un compuesto en la base de datos medianmte su ID
     * @param id ID del compuesto a borrar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteCompuesto(Long id);
}
