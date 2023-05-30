package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Pedido;
import com.echueca.clabtool.repository.PedidoRepository;
import com.echueca.clabtool.service.interfaces.IPedidoService;
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
public class PedidoController {
    
    @Autowired
    private IPedidoService pedidoService;
    
    /**
     * Devuelve los pedidos almacenados en la base de datos
     * @return Lista de pedidos
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @GetMapping("/pedido")
    public List<Pedido> getPedido() throws JsonProcessingException, IOException {
        return this.pedidoService.getPedido();
    }
    
    /**
     * Realiza una búsqueda de pedido por su ID
     * @param id ID del pedido a buscar
     * @return Pedido si la búsqueda fue satisfactoria, falso en caso contrario
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @GetMapping("/pedido/{id}")
    public Pedido getPedidoById(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.pedidoService.getPedidoById(id);
    }
    
    /**
     * Inesrta un nuevo pedido en la base de datos
     * @param pedido Pedido a insertar
     * @return Mensaje de respuesta
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @PostMapping("/pedido")
    public ResponseEntity<?> savePedido(@RequestBody Pedido pedido) throws JsonProcessingException, IOException {
        return this.pedidoService.savePedido(pedido);
    }
    
    /**
     *
     * @param pedido
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @PutMapping("/pedido")
    public ResponseEntity<?> updatePedido(@RequestBody Pedido pedido) throws JsonProcessingException, IOException {
        return this.pedidoService.updatePedido(pedido);
    }
    
    /**
     *
     * @param id
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     * @throws java.io.IOException
     */
    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id) throws JsonProcessingException, IOException {
        return this.pedidoService.deletePedido(id);
    }
}
