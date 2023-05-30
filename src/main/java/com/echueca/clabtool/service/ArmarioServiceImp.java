package com.echueca.clabtool.service;

import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Armario;
import com.echueca.clabtool.repository.ArmarioRepository;
import com.echueca.clabtool.service.interfaces.IArmarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz IArmarioService
 * @author Eduardo Chueca Montaner
 */
@Service
public class ArmarioServiceImp implements IArmarioService {
    
    @Autowired
    private ArmarioRepository armarioRepository;
    
    /**
     * Consulta todos los armarios de la base de datos
     * @return lista de armarios
     */
    @Override
    public List<Armario> getArmario() {
        return this.armarioRepository.findAll();
    }

    /**
     * Consulta un armario por la clave ID
     * @param id Id del armario
     * @return Armario en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public Armario getArmarioById(Long id) {
        return this.armarioRepository.findById(id).get();
    }

    /**
     * Inserta un nuevo armario en la base de datos
     * @param armario Armario a insertar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveArmario(Armario armario) {
        // Buscar si un armario ya utiliza dicho nombre
        Armario testEntity = this.armarioRepository.findByNombre(armario.getNombre());
        
        if( testEntity == null ) {
            // Si no esta en uso guardar armario
            this.armarioRepository.save(armario);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Armario creado."));
        }
        // Si esta en uso cancelar consulta y devolver alerta
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El nombre de armario ya está en uso"));
    }

    /**
     * Actualiza un armario existente en la base de datos
     * @param armario Armario a actualizar
     * @return mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateArmario(Armario armario) {
        // Buscar si un armario ya utiliza dicho nombre
        Armario testEntity = this.armarioRepository.findByNombre(armario.getNombre());
        
        // Comprobar si esta en uso por un armario diferente al actual
        if( testEntity != null && testEntity.getId() != armario.getId() ) {
            // Cancelar consulta y devolver alerta
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El nombre de armario ya está en uso"));
        }
        //Guardar
        this.armarioRepository.save(armario);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Armario actualizado."));      
    }

    /**
     * Borra un armario de la base de datos
     * @param id ID del armario a borrar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteArmario(Long id) {
        this.armarioRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Armario eliminado."));
    }
}
