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
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     *
     * @return
     */
    @Override
    public List<Envase> getEnvase() {
        return this.envaseRepository.findAll();
    }
    
    /**
     *
     * @param envase
     * @return
     */
    @Override
    public List<EnvaseResponseDTO> getEnvaseAsUser(EnvaseSearchDTO envase) {
         
        List<Envase> search = new ArrayList<>();
        boolean searchStarted = false;
        if( envase.getCompuestoId() > 0L ){
            Optional<Compuesto> tryCompuesto = this.compuestoRepository.findById(envase.getCompuestoId());
            if( tryCompuesto.isPresent() ) {
                search = searchForCompuesto(tryCompuesto.get());
                searchStarted = true;
            } else {
                return new ArrayList<>();
            }        
        }
        
        if( envase.getCodigo() != null && !envase.getCodigo().equals("") ) {
            search = searchForCodigo(envase.getCodigo(), search, searchStarted);
            searchStarted = true;
        }
        
        if( envase.getNombre() != null && !envase.getNombre().equals("") ) {
            search = searchForNombre(envase.getNombre(), search, searchStarted);
        }
        if( search == null || search.size() < 1 ) {
            return new ArrayList<>();
        }
        List<EnvaseResponseDTO> result = new ArrayList<>();
        List<UsoEnvase> envasesUso = this.usoEnvaseRepository.findByFechaDevolucionNotNull();
        for( Envase e: search ) {
            if( e.getPropiedades().getPureza() < envase.getPureza() ) {
                continue;
            }
            Usuario usuario = null;
            for( UsoEnvase ue: envasesUso ) {
                if( ue.getEnvase().getId() == e.getId() ) {
                    usuario = ue.getUsuario();
                }
            }
            
            EnvaseResponseDTO buffer = new EnvaseResponseDTO(e.getId(),
                e.getCantidad(),
                e.getPropiedades(),
                usuario);
            
            result.add(buffer);
        }
        return result;
    }

    /**
     *
     * @param envase
     * @return
     */
    @Override
    public ResponseEntity<?> saveEnvase(Envase envase) {
        this.envaseRepository.save(envase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase guardado"));
    }

    /**
     *
     * @param envase
     * @return
     */
    @Override
    public ResponseEntity<?> updateEnvase(Envase envase) {
        this.envaseRepository.save(envase);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase actualizado"));
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<?> deleteEnvase(Long id) {
        this.envaseRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Envase borrado"));
    }
    
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