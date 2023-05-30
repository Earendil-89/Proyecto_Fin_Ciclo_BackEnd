package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Compuesto;
import com.echueca.clabtool.service.interfaces.ICompuestoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Procesa peticiones HTTP para realizar un CRUD en la base de datos
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class CompuestoController {
    
    @Autowired
    private ICompuestoService compuestoService;
    
    /**
     * Solicita todos los compuestos químicos almacenados en la base de datos
     * @return Lista con todos los compuestos químicos
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/compuesto")
    public List<Compuesto> getCompuesto() throws JsonProcessingException, IOException {
        return this.compuestoService.getCompuesto();
    }
    
    /**
     * Realiza una búsqueda de compuesto químico por ID
     * @param id Parámetro de búsqueda
     * @return Compuesto químico si la búsqueda fué satisfactoria, null en caso contrario
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/compuesto/{id}")
    public Compuesto getCompuestoById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.compuestoService.getCompuestoById(id);
    }
    
    /**
     * Inserta un nuevo compuesto en la base de datos
     * @param compuesto Compuesto a insertar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PostMapping("/compuesto")
    public ResponseEntity<?> saveCompuesto(@RequestBody Compuesto compuesto) throws JsonProcessingException, IOException {
        return this.compuestoService.saveCompuesto(compuesto);
    }
    
    /**
     * Actualiza un compuesto existente en la base de datos
     * @param compuesto Compuesto a editar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PutMapping("/compuesto")
    public ResponseEntity<?> updateCompuesto(@RequestBody Compuesto compuesto) throws JsonProcessingException, IOException {
        return this.compuestoService.updateCompuesto(compuesto);
    }
   
    /**
     * Elimina un compuesto de la base de datos
     * @param id ID del compuesto a borrar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @DeleteMapping("/compuesto/{id}")
    public ResponseEntity<?> deleteCompuesto(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.compuestoService.deleteCompuesto(id);
    }
}
