package com.echueca.clabtool.service;

import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.EnvaseProp;
import com.echueca.clabtool.repository.EnvasePropRepository;
import com.echueca.clabtool.repository.EnvaseRepository;
import org.springframework.stereotype.Service;
import com.echueca.clabtool.service.interfaces.IEnvasePropService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 * Clase que implementa la interfaz IEnvasePropService
 * @author Eduardo Chueca Montaner
 */
@Service
public class EnvasePropServiceImp implements IEnvasePropService {
    
    @Autowired
    private EnvasePropRepository envasePropRepository;
    @Autowired
    private EnvaseRepository envaseRepository;

    /**
     * Busca todas las propiedades de envases de la base de datos
     * @return Lista con propiedades de envases
     */
    @Override
    public List<EnvaseProp> getEnvaseProp() {
        return this.envasePropRepository.findAll();
    }

    /**
     * Busca una propiedad de envases por su ID
     * @param id ID de la propiedad de envases a buscar
     * @return EnvaseProp en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public EnvaseProp getEnvasePropById(Long id) {
        Optional<EnvaseProp> attemptEntity = this.envasePropRepository.findById(id);
        return attemptEntity.isPresent() ? attemptEntity.get() : null;
    }

    /**
     * Inserta una nueva propiedad de envases en la base de datos
     * @param envaseProp Propiedad de envases a insertar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveEnvaseProp(EnvaseProp envaseProp) {
        EnvaseProp testEntity = this.envasePropRepository.findByCodigo(envaseProp.getCodigo());
        if( testEntity == null ) {
            this.envasePropRepository.save(envaseProp);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Datos de envase creados"));
        }
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El código especificado ya existe"));
    }

    /**
     * Actualiza una propiedad de envases existente en la base de datos
     * @param envaseProp Propiedad de envases a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateEnvaseProp(EnvaseProp envaseProp) {
        EnvaseProp testEntity = this.envasePropRepository.findByCodigo(envaseProp.getCodigo());
        if( testEntity != null && testEntity.getId() != envaseProp.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El código especificado ya está en uso"));
        }
        this.envasePropRepository.save(envaseProp);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Datos de envase actualizados"));
    }

    /**
     * Elimina una propiedad de envases de la base de datos
     * @param id ID de la propiedad de envases a eliminar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteEnvaseProp(Long id) {
        // Extraer la propiedad de envases
        Optional<EnvaseProp> testEP = this.envasePropRepository.findById(id);
        if( testEP.isEmpty() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "No se puede borrar, la entrada no existe."));
        } else {
           // Buscar envases activos que tengan esta propiedad de envase
            List<Envase> testEnvases = this.envaseRepository.findByPropiedadesAndDisponible(testEP.get(), true);
            if( testEnvases != null && testEnvases.size() > 0 ) {
                // Cancelar borrado si hay envases activos
                return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "No se puede borrar, hay envases activos que requieren este objeto."));
            }
        }

        this.envasePropRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Datos de envase borrados"));
    }
}
