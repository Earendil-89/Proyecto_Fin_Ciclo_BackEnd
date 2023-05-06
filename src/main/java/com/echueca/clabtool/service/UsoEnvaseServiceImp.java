package com.echueca.clabtool.service;

import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.UsoEnvase;
import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.repository.UsoEnvaseRepository;
import com.echueca.clabtool.repository.UsuarioRepository;
import com.echueca.clabtool.service.interfaces.IUsoEnvaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class UsoEnvaseServiceImp implements IUsoEnvaseService {

    @Autowired
    private UsoEnvaseRepository usoEnvaseRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public List<UsoEnvase> getUsoEnvase() {
        return this.usoEnvaseRepository.findAll();
    }

    @Override 
    public List<UsoEnvase> getActiveUsoEnvase() {
        return this.usoEnvaseRepository.findByFechaDevolucionNotNull();
    }
    @Override
    public UsoEnvase getUsoEnvaseById(Long id) {
        return this.usoEnvaseRepository.findById(id).get();
    }
    
    @Override
    public List<UsoEnvase> getUsoEnvaseByUserId(Long id) {
        Usuario usuario = this.usuarioRepository.findById(id).get();
        
        return this.usoEnvaseRepository.findByUsuario(usuario);
    }

    @Override
    public ResponseEntity<?> startUsoEnvase(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<?> endUsoENvase(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<?> saveUsoEnvase(Envase envase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<?> updateUsoEnvase(Envase envase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResponseEntity<?> deleteUsoEnvase(Envase envase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
