package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Armario;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Objeto que desarrolla los serivicos de Armario
 * @author Eduardo Chueca Montaner
 */
public interface IArmarioService {
    
    /**
     * Consulta todos los armarios de la base de datos
     * @return lista de armarios
     */
    public List<Armario> getArmario();
    
    /**
     * Consulta un armario por la clave ID
     * @param id Id del armario
     * @return Armario en caso satisfactorio, nulo en caso contrario
     */
    public Armario getArmarioById(Long id);
    
    /**
     * Inserta un nuevo armario en la base de datos
     * @param armario Armario a insertar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> saveArmario(Armario armario);
    
    /**
     * Actualiza un armario existente en la base de datos
     * @param armario Armario a actualizar
     * @return mensaje de respuesta
     */
    public ResponseEntity<?> updateArmario(Armario armario);
    
    /**
     * Borra un armario de la base de datos
     * @param id ID del armario a borrar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deleteArmario(Long id);
}
