package com.echueca.clabtool.service;

import com.echueca.clabtool.service.interfaces.IPedidoService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Pedido;
import com.echueca.clabtool.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz IPedidoService
 * @author Eduardo Chueca Montaner
 */
@Service
public class PedidoServiceImp implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    /**
     * Busca todos los pedidos de la base de datos
     * @return Lista con los pedidos
     */
    @Override
    public List<Pedido> getPedido() {
        return this.pedidoRepository.findAll();
    }
    
    /**
     * Busca un pedido por su numero ID
     * @param id ID del pedido
     * @return Pedido en caso satisfactorio, nulo en caso contrario
     */
    @Override
    public Pedido getPedidoById(Long id) {
        return this.pedidoRepository.findById(id).get();
    }

    /**
     * Inserta un pedido nuevo en la base de datos
     * @param pedido Pedido a insertar
     * @return
     */
    @Override
    public ResponseEntity<?> savePedido(Pedido pedido) {
        this.pedidoRepository.save(pedido);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Pedido guardado."));
    }

    /**
     * Actualiza un pedido existente en la base de datos
     * @param pedido Pedido a actualizar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> updatePedido(Pedido pedido) {
        this.pedidoRepository.save(pedido);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Pedido actualizado."));
    }

    /**
     * Elimina un pedido existente en la base de datos
     * @param id ID del pedido a eliminar
     * @return Mensaje de respuesta
     */
    @Override
    public ResponseEntity<?> deletePedido(Long id) {
        this.pedidoRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Pedido borrado."));
    }
}
