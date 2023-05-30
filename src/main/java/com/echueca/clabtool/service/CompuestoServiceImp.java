package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.ICompuestoService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.repository.CompuestoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz ICompuestoService
 * @author Eduardo Chueca Montaner
 */
@Service
public class CompuestoServiceImp implements ICompuestoService {
    
    @Autowired
    private CompuestoRepository compuestoRepository;

    /**
     * Consulta todos los compuestos químicos de la base de datos
     * @return Lista con todos los compuestos
     */
    @Override
    public List<Compuesto> getCompuesto() {
        return this.compuestoRepository.findAll();
    }

    /**
     * Busca un compuesto químico por su ID
     * @param id ID del compuesto químico
     * @return Compuesto en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public Compuesto getCompuestoById(Long id) {
        return this.compuestoRepository.findById(id).get();
    }

    /**
     * Inserta un nuevo compuesto en la base de datos
     * @param compuesto Compuesto a insertar
     * @return mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveCompuesto(Compuesto compuesto) {
        // Buscar compuestos que tengan el mismo numbero CAS
        Compuesto testCompuesto = this.compuestoRepository.findByCas(compuesto.getCas());
        
        if( testCompuesto == null ) {
            // Guardar compuesto quimico si el CAS no esta en uso
            this.compuestoRepository.save(compuesto);
            return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Compuesto químico creado."));
        }
        // Cancelar consulta y devolver alerta si el CAS coincide
        return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El número CAS ya está registrado."));
    }

    /**
     * Actualiza un compuesto en la base de datos
     * @param compuesto Compuesto a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateCompuesto(Compuesto compuesto) {
        // Buscar compuestos que estén usando el número CAS
        Compuesto testCompuesto = this.compuestoRepository.findByCas(compuesto.getCas());
        
        // Comprobar si esta en uso y por un compuesto diferente
        if( testCompuesto != null && testCompuesto.getId() != compuesto.getId() ) {
            // Cancelar consulta y devolver alerta
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El número CAS está en uso por otro compuesto."));
        }
        // Realizar consulta
        this.compuestoRepository.save(compuesto);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Compuesto químico actualizado."));
    }

    /**
     * Borra un compuesto en la base de datos medianmte su ID
     * @param id ID del compuesto a borrar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteCompuesto(Long id) {
        this.compuestoRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Compuesto químico borrado."));
    }
}
