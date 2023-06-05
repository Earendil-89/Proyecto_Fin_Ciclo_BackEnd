package com.echueca.clabtool.service;

import com.echueca.clabtool.DTO.EnvaseResponseDTO;
import com.echueca.clabtool.DTO.EnvaseSearchDTO;
import com.echueca.clabtool.service.interfaces.IEnvaseService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.EnvaseProp;
import com.echueca.clabtool.model.UsoEnvase;
import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.repository.CompuestoRepository;
import com.echueca.clabtool.repository.EnvasePropRepository;
import com.echueca.clabtool.repository.EnvaseRepository;
import com.echueca.clabtool.repository.UsoEnvaseRepository;
import com.echueca.clabtool.repository.UsuarioRepository;
import java.util.ArrayList;
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
public class EnvaseServiceImp implements IEnvaseService {
    
    @Autowired
    private EnvaseRepository envaseRepository;
    @Autowired
    private EnvasePropRepository envasePropRepository;
    @Autowired
    private CompuestoRepository compuestoRepository;
    @Autowired
    private UsoEnvaseRepository usoEnvaseRepository;

    /**
     * Devuelve todos los envases almacenados en la base de datos
     * @return Lista de envases
     */
    @Override
    public List<Envase> getEnvase() {
        return this.envaseRepository.findAll();
    }
    
    /**
     * Devuelve el resultado de una consulta con datos limitados
     * @param envase Objeto DTO para buscar envase
     * @return Lista de objetos DTO con datos de envase limitados
     */
    @Override
    public List<EnvaseResponseDTO> getEnvaseAsUser(EnvaseSearchDTO envase) {
         
        List<Envase> search = new ArrayList<>();    // Lista que contiene todos los matches
        boolean searchStarted = false;
        // Comprobar si se ha pedido una busqueda por compuesto mediante el ID del compuesto
        if( envase.getCompuestoId() > 0L ){
            Optional<Compuesto> tryCompuesto = this.compuestoRepository.findById(envase.getCompuestoId());
            if( tryCompuesto.isPresent() ) {
                // Añadir todos los envases que contengan dicho compuesto quimico a la lista
                search = searchForCompuesto(tryCompuesto.get());
                searchStarted = true;
            } else {
                return new ArrayList<>();
            }        
        }
        // Comprobar si se ha enviado un codigo de EnvaseProp para hacer búsqueda
        if( envase.getCodigo() != null && !envase.getCodigo().equals("") ) {
            // Editar la lista con el nuevo resultado
            search = searchForCodigo(envase.getCodigo(), search, searchStarted);
            searchStarted = true;
        }
        // Comprobar si se ha pasado una búsqueda por nombre y añadir a l
        if( envase.getNombre() != null && !envase.getNombre().equals("") ) {
            search = searchForNombre(envase.getNombre(), search, searchStarted);
        }
        // Devolver un arraylist vacio si no hubieron resultados
        if( search == null || search.size() < 1 ) {
            return new ArrayList<>();
        }
        
        List<EnvaseResponseDTO> result = new ArrayList<>(); // Lista con los resultados
        List<UsoEnvase> envasesUso = this.usoEnvaseRepository.findByFechaDevolucionNotNull(); // Lista con todos los envases en uso
        // Llenar la lista de resultados
        for( Envase e: search ) {
            // No añadir los que no cumplan el requisito de pureza mínima
            if( e.getPropiedades().getPureza() < envase.getPureza() ) {
                continue;
            }
            // Busca si un usuario esta utilizando el envase en dicho momento
            Usuario usuario = null;
            for( UsoEnvase ue: envasesUso ) {
                if( ue.getEnvase().getId() == e.getId() && ue.getFechaDevolucion() == null ) {
                    usuario = ue.getUsuario();
                }
            }
            //Crea las respuestas de envase
            EnvaseResponseDTO buffer = new EnvaseResponseDTO(e.getId(),
                e.getCantidad(),
                e.getPropiedades(),
                usuario);
            
            result.add(buffer);
        }
        return result;
    }

    /**
     * Inserta un nuevo envase en la base de datos
     * @param envase Envase a insertar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> saveEnvase(Envase envase) {
        this.envaseRepository.save(envase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase guardado"));
    }

    /**
     * Actualiza un envase existente en la base de datos
     * @param envase Envase a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updateEnvase(Envase envase) {
        this.envaseRepository.save(envase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase actualizado"));
    }

    /**
     * Elimina un envase de la base de datos
     * @param id ID del envase
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deleteEnvase(Long id) {
        this.envaseRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase borrado"));
    }
    
    // Devuelve una lista de envases que contengan el compuesto enviado
    private List<Envase> searchForCompuesto(Compuesto compuesto) {
        List<EnvaseProp> epCompuesto = this.envasePropRepository.findByCompuesto(compuesto);
        
        if( epCompuesto == null || epCompuesto.size() < 1 ) {
            return new ArrayList<>();
        }
        
        List<Envase> result = new ArrayList<>();
        for( EnvaseProp ep: epCompuesto ) {
            List<Envase> buffer = this.envaseRepository.findByPropiedades(ep);
            if( buffer.size() < 1 ) {
                continue;
            }
            for( Envase e: buffer ) {
                if( !result.contains(e) ) {
                    result.add(e);
                }
            }
        }
        return result;
    }
    
    // Busca todos los envases que coincidan con el codigo enviado
    private List<Envase> searchForCodigo(String codigo, List<Envase> input, boolean exclusiveSearch) {
        
        List<EnvaseProp> epCodigo = this.envasePropRepository.findByCodigoContainsIgnoreCase(codigo);
        
        if( epCodigo == null || epCodigo.size() < 1 ) {
            return new ArrayList<>();
        }
        
        List<Envase> result = new ArrayList<>();
        for( EnvaseProp ep: epCodigo ) {
            List<Envase> buffer = this.envaseRepository.findByPropiedades(ep);
            if( buffer == null || buffer.size() < 1 ) {
                continue;
            }
            
            for( Envase e: buffer ) {
                if( !result.contains(e) ) {
                    result.add(e);
                }
            }
        }
        if( !exclusiveSearch ) {
            return result;
        }
        
        List<Envase> buffer = new ArrayList<>(result);
        result = new ArrayList<>();
        for( Envase e: input ) {
            if( buffer.contains(e) ) {
                result.add(e);
            }
        }
        return result;
    }
    
    // Busca todos los envases cuyo EnvaseProp o compuesto contengan el nombre pasado como parametro
    private List<Envase> searchForNombre(String nombre, List<Envase> input, boolean exclusiveSearch) {
        List<EnvaseProp> epSearch = this.envasePropRepository.findByNombreContainsIgnoreCase(nombre);
        List<Compuesto> cSearch = this.compuestoRepository.findByNombreContainsIgnoreCase(nombre);
        
        for( Compuesto c: cSearch ) {
            List<EnvaseProp> epResult = this.envasePropRepository.findByCompuesto(c);
            for( EnvaseProp ep: epResult ) {
                if( !epSearch.contains(ep) ) {
                    epSearch.add(ep);
                }
            }
        }
        List<Envase> result = new ArrayList<>();
        
        for( EnvaseProp ep: epSearch ) {
            List<Envase> buffer = this.envaseRepository.findByPropiedades(ep);
            if( result.size() < 1 ) {
                result = new ArrayList<>(buffer);
                continue;
            }
            for( Envase e: buffer ) {
                if( !result.contains(e) ){
                    result.add(e);
                }
            }
        }
        if( exclusiveSearch ) {
            List<Envase> buffer = new ArrayList<>(result);
            result = new ArrayList<>();
            for( Envase e: buffer ) {
                for( Envase e2: input ) {
                    if( e2.getId() == e.getId() ) {
                        result.add(e);
                    }
                }
            }
        }
        return result;
    }
}