package com.echueca.clabtool.controller;

import com.echueca.clabtool.DTO.SolicitudCreateDTO;
import com.echueca.clabtool.DTO.SolicitudProcessDTO;
import com.echueca.clabtool.model.Solicitud;
import com.echueca.clabtool.service.interfaces.ISolicitudService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
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
 * Procesa peticiones HTTP para realizar un CRUD en la base de datos
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class SolicitudController {
    
    @Autowired
    private ISolicitudService solicitudService;
    
    /**
     * Devuelve las solicitudes almaecnadas en la base de datos
     * @return Lista de solicitudes
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @GetMapping("/solicitud")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<Solicitud> getSolicitud() throws JsonProcessingException, IOException {
        return this.solicitudService.getSolicitud();
    }
    
    /**
     * Devuelve una solicitud en base a un nombre de usuario
     * @param nombreUsuario Nombre de usuario a buscar
     * @return Lista de solicitudes
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @GetMapping("/solicitud/usuario")
    @PreAuthorize("hasRole('USER') or hasRole('INSPECTOR')")
    public List<Solicitud> getSolicitudByNombreUsuario(@RequestParam(name = "nombreUsuario") String nombreUsuario) throws JsonProcessingException, IOException {
        return this.solicitudService.getSolicitudByNombreUsuario(nombreUsuario);
    }
    
    /**
     * Devuelve solo las solicitudes activas
     * @return Lista de solicitudes
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @GetMapping("/solicitud?activa=true")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<Solicitud> getActiveSolicitud() throws JsonProcessingException, IOException {
        return this.solicitudService.getActiveSolicitud();
    }
    
    /**
     * Devuelve solo las solicitudes tramitadas
     * @return Lista de solicitudes
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @GetMapping("/solicitud?activa=false")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<Solicitud> getInactiveSolicitud() throws JsonProcessingException, IOException {
        return this.solicitudService.getInactiveSolicitud();
    }
    
    /**
     * Realiza una consulta de solicitud por ID
     * @param id ID de la solicitud
     * @return Solicitud si la busqueda fue satisfactoria, nulo en caso contrario
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @GetMapping("/solicitud/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public Solicitud getSolicitudById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.solicitudService.getSolicitudById(id);
    }
    
    /**
     * Devuelve una solicitud en base al ID del usuario
     * @param userId ID del usuario a buscar
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @GetMapping("/usuario/{userId}/solicitud")
    @PreAuthorize("hasRole('INSPECTOR')")
    public List<Solicitud> getSolicitudByUsuarioId(@PathVariable Long userId) throws JsonProcessingException, IOException {
        return this.solicitudService.getSolicitudByUsuarioId(userId);
    }
    
    /**
     * Inserta una nueva solicitud en la base de datos
     * @param solicitud Solicitud a insertar
     * @return Mensaje de respuesta
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @PostMapping("/solicitud")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> saveSolicitud(@RequestBody Solicitud solicitud) throws JsonProcessingException, IOException {
        return this.solicitudService.saveSolicitud(solicitud);
    }
    
    /**
     * Actualiza una solicitud en la base de datos
     * @param solicitud Solicitud a actualizar
     * @return Mensaje de respuesta
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @PutMapping("/solicitud")
    @PreAuthorize("hasRole('USER') or hasRole('INSPECTOR')")
    public ResponseEntity<?> updateSolicitud(@RequestBody Solicitud solicitud) throws JsonProcessingException, IOException {
        return this.solicitudService.updateSolicitud(solicitud);
    }
    
    /**
     * Procesa una solicitud y cambia su estado de trámite almacenando el técnico que la tramitó
     * @param solicitud Solicitud a tramitar
     * @param nombreUsuario Nombre del usuario que ha realizado el trámite
     * @return Mensaje de respuesta
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @PutMapping("solicitud/usuario")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> processSolicitud(@RequestBody SolicitudProcessDTO solicitud, @RequestParam(name = "nombreUsuario") String nombreUsuario) throws JsonProcessingException, IOException {
        return this.solicitudService.processSolicitud(solicitud, nombreUsuario);
    }
    
    /**
     * Inserta una nueva solicitud en la base de datos incluyendo el usuario que la creó
     * @param solicitud Solicitud a insertar
     * @param nombreUsuario Nombre del usuario que creó la solicitud
     * @return Mensaje de respuesta
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @PostMapping("/solicitud/usuario")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> saveSolicitudByUser(@RequestBody SolicitudCreateDTO solicitud, @RequestParam(name = "nombreUsuario") String nombreUsuario) throws JsonProcessingException, IOException {
        return this.solicitudService.saveSolicitudByUsuario(solicitud, nombreUsuario);
    }
    
    /**
     * Borra una solicitud
     * @param id ID de la solicitud a borrar
     * @return Mensaje de respuesta
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @DeleteMapping("/solicitud/{id}")
    public ResponseEntity<?> deleteSolicitud(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.solicitudService.deleteSolicitud(id);
    }
}
