package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IEtiquetaService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Etiqueta;
import com.echueca.clabtool.repository.EtiquetaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz IEtiquetaService
 * @author Eduardo Chueca Montaner
 */
@Service
public class EtiquetaServiceImp implements IEtiquetaService {
    
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    /**
     * Busca todas las etiquetas en la base de datos
     * @return Lista con todas las etiquetas
     */
    @Override
    public List<Etiqueta> getEtiqueta() {
        return this.etiquetaRepository.findAll();
    }

    /**
     * Busca una etiqueta en la base de datos por su ID
     * @param id ID de la etiqueta a buscar
     * @return Etiqueta en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public Etiqueta getEtiquetaById(Long id) {
        return this.etiquetaRepository.findById(id).get();
    }

    /**
     * Inserta una nueva etiqueta en la base de datos
     * @param etiqueta Etiqueta a insertar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveEtiqueta(Etiqueta etiqueta) {
        // Busca si existe una etiqueta con el codigo que se va a insertar
        Etiqueta testEntity = this.etiquetaRepository.findByCodigo(etiqueta.getCodigo());
        
        if( testEntity == null ) {
            this.etiquetaRepository.save(etiqueta);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta creada."));          
        }
        // Abortar la inserción en caso de que el codigo este en uso
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El codigo de la etiqueta ya existe."));
    }

    /**
     * Actualiza una etiqueta existente en la base de datos
     * @param etiqueta Etiqueta a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateEtiqueta(Etiqueta etiqueta) {
        // Buscar una etiqueta que este usando el codigo
        Etiqueta testEntity = this.etiquetaRepository.findByCodigo(etiqueta.getCodigo());
        
        if( testEntity != null && testEntity.getId() != etiqueta.getId() ) {
            // Cancelar la actualización si el codigo esta en uso por otra entidad
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El codigo está en uso por otra etiqueta."));
        }

        this.etiquetaRepository.save(etiqueta);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta actualizada."));
    }

    /**
     * Elimina una etiqueta en la base de datos
     * @param id ID de la etiquta a eliminar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteEtiqueta(Long id) {
        this.etiquetaRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Etiqueta eliminada."));
    }
}
