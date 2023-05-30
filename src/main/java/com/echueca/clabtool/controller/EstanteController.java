package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Estante;
import com.echueca.clabtool.service.interfaces.IEstanteService;
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
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clabtool")
public class EstanteController {
    
    @Autowired
    private IEstanteService estanteService;
    
    /**
     * Devuelve los estantes almacenados en la base de datos
     * @param id (Opcional) filtra estantes por el ID del armario al que pertence
     * @return Lista de estantes
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/estante")
    @PreAuthorize("hasRole('INSPECTOR') or hasRole('USER') or hasRole('ADMIN')")
    public List<Estante> getEstante(@RequestParam(name="armarioId", required=false) Long id) throws JsonProcessingException, IOException {
        if( id == null ) {
            return this.estanteService.getEstante();
        }
        return this.estanteService.getEstanteByArmarioId(id);
    } 
    
    /**
     * Realiza una búsqueda de estante por su ID
     * @param id ID del estante a buscar
     * @return Estante si la búsqueda fue satisfactoria, nulo en caso contrario
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/estante/{id}")
    @PreAuthorize("hasRole('INSPECTOR') or hasRole('USER') or hasRole('ADMIN')")
    public Estante getEstanteById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.estanteService.getEstanteById(id);
    }
    
    /**
     * Inserta un nuevo estante en la base de datos
     * @param estante Estante a insertar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PostMapping("/estante")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> saveEstante(@RequestBody Estante estante) throws JsonProcessingException, IOException {
        return this.estanteService.saveEstante(estante);
    }
    
    /**
     * Actualiza un estante existente en la base de datos
     * @param estante Estante a actualizar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PutMapping("/estante")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> updateEstante(@RequestBody Estante estante) throws JsonProcessingException, IOException {
        return this.estanteService.updateEstante(estante);
    }
    
    /**
     * Borra un estante presente en la base de datos
     * @param id ID del estante a eliminar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @DeleteMapping("/estante/{id}")
    @PreAuthorize("hasRole('INSPECTOR')")
    public ResponseEntity<?> deleteEstante(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.estanteService.deleteEstante(id);
    }
}
