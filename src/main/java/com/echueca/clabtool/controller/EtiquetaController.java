package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Etiqueta;
import com.echueca.clabtool.repository.EtiquetaRepository;
import com.echueca.clabtool.service.interfaces.IEtiquetaService;
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
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clabtool")
public class EtiquetaController {
    
    @Autowired
    private IEtiquetaService etiquetaService;
    
    /**
     * Solicita las etiquetas almacenadas en la base de datos
     * @return Lista de etiquetas
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/etiqueta")
    public List<Etiqueta> getEtiqueta() throws JsonProcessingException, IOException {
        return this.etiquetaService.getEtiqueta();
    }
    
    /**
     * Realiza una búsqueda de etiqueta por id
     * @param id ID de la etiqueta a buscar
     * @return Etiqueta si la busqueda fue satisfactoria, nulo en caso contrario
     * @throws JsonProcessingException
     * @throws IOException
     */
    @GetMapping("/etiqueta/{id}")
    public Etiqueta getEtiquetaById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.etiquetaService.getEtiquetaById(id);
    }
    
    /**
     * Inserta una nueva etiqueta en la base de datos
     * @param etiqueta Etiqueta a insertar
     * @return Mensaje de reespuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PostMapping("/etiqueta")
    public ResponseEntity<?> saveEtiqueta(@RequestBody Etiqueta etiqueta) throws JsonProcessingException, IOException {
        return this.etiquetaService.saveEtiqueta(etiqueta);
    }
    
    /**
     * Actualiza una etiqueta existente en la base de datos
     * @param etiqueta Etiqueta a actualizar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @PutMapping("/etiqueta")
    public ResponseEntity<?> updateEtiqueta(@RequestBody Etiqueta etiqueta) throws JsonProcessingException, IOException {
        return this.etiquetaService.updateEtiqueta(etiqueta);
    }
    
    /**
     * Elimina una etiqueta de la base de datos
     * @param id ID de la etiqueta a eliminar
     * @return Mensaje de respuesta
     * @throws JsonProcessingException
     * @throws IOException
     */
    @DeleteMapping("/etiqueta/{id}")
    public ResponseEntity<?> deleteEtiqueta(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.etiquetaService.deleteEtiqueta(id);
    }
}
