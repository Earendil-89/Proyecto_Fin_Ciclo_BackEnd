package com.echueca.clabtool.controller;

import com.echueca.clabtool.DTO.SolicitudDTO;
import com.echueca.clabtool.model.Solicitud;
import com.echueca.clabtool.service.interfaces.ISolicitudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class SolicitudController {
    
    @Autowired
    private ISolicitudService solicitudService;
    
    @GetMapping("/solicitud")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<Solicitud> getSolicitud() {
        return this.solicitudService.getSolicitud();
    }
    
    @GetMapping("/solicitud/usuario")
    @PreAuthorize("hasRole('USER') or hasRole('INSPECTOR')")
    public List<Solicitud> getSolicitudByNombreUsuario(@RequestParam(name = "nombreUsuario") String nombreUsuario) {
        return this.solicitudService.getSolicitudByNombreUsuario(nombreUsuario);
    }
    
    @GetMapping("/solicitud?activa=true")
    public List<Solicitud> getActiveSolicitud() {
        return this.solicitudService.getActiveSolicitud();
    }
    
    @GetMapping("/solicitud?activa=false")
    public List<Solicitud> getInactiveSolicitud() {
        return this.solicitudService.getInactiveSolicitud();
    }
    
    @GetMapping("/solicitud/{id}")
    public Solicitud getSolicitudById(@PathVariable Long id) {
        return this.solicitudService.getSolicitudById(id);
    }
    
    @GetMapping("/usuario/{userId}/solicitud")
    public List<Solicitud> getSolicitudByUsuarioId(@PathVariable Long userId) {
        return this.solicitudService.getSolicitudByUsuarioId(userId);
    }
    
    @PostMapping("/solicitud")
    public ResponseEntity<?> saveSolicitud(@RequestBody Solicitud solicitud) {
        return this.solicitudService.saveSolicitud(solicitud);
    }
    
    @PutMapping("/solicitud")
    public ResponseEntity<?> updateSolicitud(@RequestBody Solicitud solicitud) {
        return this.solicitudService.updateSolicitud(solicitud);
    }
    
    @PostMapping("/solicitud/usuario")
    public ResponseEntity<?> saveSolicitudByUser(@RequestBody SolicitudDTO solicitud, @RequestParam(name = "nombreUsuario") String nombreUsuario) {
        return this.solicitudService.saveSolicitudByUsuario(solicitud, nombreUsuario);
    }
    
    @PutMapping("/solicitud/usuario")
    public ResponseEntity<?> updateSolicitudByUser(@RequestBody SolicitudDTO solicitud, @RequestParam(name = "nombreUsuario") String nombreUsuario) {
        return this.solicitudService.updateSolicitudByUsuario(solicitud, nombreUsuario);
    }
    
    @DeleteMapping("/solicitud/{id}")
    public ResponseEntity<?> deleteSolicitud(@PathVariable Long id) {
        return this.solicitudService.deleteSolicitud(id);
    }
}
