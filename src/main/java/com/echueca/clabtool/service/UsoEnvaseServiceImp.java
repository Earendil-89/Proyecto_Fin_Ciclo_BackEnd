package com.echueca.clabtool.service;

import com.echueca.clabtool.DTO.EnvaseExtractDTO;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.UsoEnvase;
import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.repository.EnvaseRepository;
import com.echueca.clabtool.repository.UsoEnvaseRepository;
import com.echueca.clabtool.repository.UsuarioRepository;
import com.echueca.clabtool.service.interfaces.IUsoEnvaseService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class UsoEnvaseServiceImp implements IUsoEnvaseService {

    @Autowired
    private UsoEnvaseRepository usoEnvaseRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnvaseRepository envaseRepository;
    
    /**
     * Busca todos los usos de envases en la base de datos
     * @return Lista con los usos de envase
     */
    @Override
    public List<UsoEnvase> getUsoEnvase() {
        return this.usoEnvaseRepository.findAll();
    }

    /**
     * Busca todos los usos de envase activos 
     * @return Lista con usos de envase
     */
    @Override 
    public List<UsoEnvase> getActiveUsoEnvase() {
        return this.usoEnvaseRepository.findByFechaDevolucionNotNull();
    }

    /**
     * Busca un uso de envase por su ID
     * @param id ID del uso de envase
     * @return UsoEnvase en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public UsoEnvase getUsoEnvaseById(Long id) {
        return this.usoEnvaseRepository.findById(id).get();
    }
    
    /**
     * Busca todos los usos de envase por el id de un usuario
     * @param id ID del usuario
     * @return Lista con usos de envase
     */
    @Override
    public List<UsoEnvase> getUsoEnvaseByUserId(Long id) {
        Usuario usuario = this.usuarioRepository.findById(id).get();
        
        return this.usoEnvaseRepository.findByUsuario(usuario);
    }

    /**
     * Busca todos los usos de envase activos por usuario
     * @param nombreUsuario Nombre del usuario
     * @return Lista con unosos de envase
     */
    @Override
    public List<UsoEnvase> getActiveUsoEnvaseByNombreUsuario(String nombreUsuario) {
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
        
        return this.usoEnvaseRepository.findByUsuarioAndFechaDevolucionIsNull(usuario);
    }

    /**
     * Crea un nuevo uso de envase en la base de datos como una extraccion de envase
     * @param extr Datos de la extraccion
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveUsoEnvase(EnvaseExtractDTO extr) {
        Optional<Envase> envase = this.envaseRepository.findById(extr.getId());
        if( envase.isEmpty() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "Error: El envase no existe."));
        }
        
        List<UsoEnvase> testEnvase = this.usoEnvaseRepository.findByEnvaseAndFechaDevolucionNotNull(envase.get());
        if( testEnvase != null && !testEnvase.isEmpty() ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "Error: El envase ya está en uso por otro usuario."));
        }
        
        Usuario usuario = this.usuarioRepository.findByNombreUsuario(extr.getNombreUsuario());
        UsoEnvase usoEnvase = new UsoEnvase();
        usoEnvase.setEnvase(envase.get());
        usoEnvase.setUsuario(usuario);
        usoEnvase.setRazonUso(extr.getRazonUso());
        usoEnvase.setFechaUso(new Date());
        
        this.usoEnvaseRepository.save(usoEnvase);
        
        String message = String.format("Armario: %s. Estante: %s", envase.get().getEstante().getArmario().getNombre(), envase.get().getEstante().getNombre());
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, message));    
    }

    /**
     * Actualiza un uso de envase presente en la base de datos
     * @param usoEnvase Uso de envase a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateUsoEnvase(UsoEnvase usoEnvase) {
        // Guardar el uso de envase
        this.usoEnvaseRepository.save(usoEnvase);
        // Buscar la entidad envase de la base de datos
        Optional<Envase> testEnvase = this.envaseRepository.findById(usoEnvase.getEnvase().getId());
        if( testEnvase.isPresent() ) {
            Envase envase = testEnvase.get();
            // Agotar el envase si es necesario
            if( usoEnvase.isAgotado() ) {
                envase.setDisponible(false);
                envase.setCantidad(0.0);
                // Reducir la cantidad de reactivo en el envase
            } else if( usoEnvase.getCantidadUsada() > 0.0 ) {
                envase.setCantidad(envase.getCantidad() - usoEnvase.getCantidadUsada() );
            }
            this.envaseRepository.save(envase);
        }
        String message = String.format(" RECUERDA DEVOLVER: Armario: %s. Estante: %s", usoEnvase.getEnvase().getEstante().getArmario().getNombre(), usoEnvase.getEnvase().getEstante().getNombre());
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, message));    }

    /**
     * Elimina un uso de envase de la base de datos
     * @param id ID del uso de envase
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteUsoEnvase(Long id) {
        this.usoEnvaseRepository.deleteById(id);
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Uso de envase borrado"));
    }
    
}