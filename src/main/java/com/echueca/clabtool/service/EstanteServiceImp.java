package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IEstanteService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Armario;
import com.echueca.clabtool.model.Estante;
import com.echueca.clabtool.repository.ArmarioRepository;
import com.echueca.clabtool.repository.EstanteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class EstanteServiceImp implements IEstanteService {
    
    @Autowired
    private EstanteRepository estanteRepository;
    
    @Autowired
    private ArmarioRepository armarioRepository;

    /**
     * Busca todos los estantes almacenados en la base de datos
     * @return Lista con estantes
     */
    @Override
    public List<Estante> getEstante() {
        return this.estanteRepository.findAll();
    }

    /**
     * Busca un estante por su ID
     * @param id ID del estante
     * @return Estante en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public Estante getEstanteById(Long id) {
        return this.estanteRepository.findById(id).get();
    }
    
    /**
     * Busca un estante por el ID del armario al que pertenece
     * @param id ID del armario
     * @return Lista con estantes
     */
    @Override
    public List<Estante> getEstanteByArmarioId(Long id) {
        Armario armario = this.armarioRepository.findById(id).get();
        
        return this.estanteRepository.findByArmario(armario);
    }

    /**
     * Inserta un estante en la base de datos
     * @param estante Estante a insertar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveEstante(Estante estante) {
        Estante testEstante = estanteRepository.findByNombre(estante.getNombre());
        
        if( testEstante == null ) {
            this.estanteRepository.save(estante);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Estante creado corréctamente."));
        }
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El nombre de estante ya está en uso."));
    }

    /**
     * Actualiza un estante existente en la base de datos
     * @param estante Estante a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateEstante(Estante estante) {
        Estante testEstante = estanteRepository.findByNombre(estante.getNombre());
        
        if( testEstante != null && testEstante.getId() != estante.getId() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El nombre de estante está en uso."));
        }
        this.estanteRepository.save(estante);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Estante actualizado corréctamente."));
    }

    /**
     * Elimina un estante de la base de datos
     * @param id ID del envase a eliminar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteEstante(Long id) {
        this.estanteRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Estante borrado."));
    }
}