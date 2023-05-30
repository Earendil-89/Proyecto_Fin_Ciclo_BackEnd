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
 *
 * @author Eduardo Chueca Montaner
 */
@Service
public class PedidoServiceImp implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    /**
     *
     * @return
     */
    @Override
    public List<Pedido> getPedido() {
        return this.pedidoRepository.findAll();
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Pedido getPedidoById(Long id) {
        return this.pedidoRepository.findById(id).get();
    }

    /**
     *
     * @param pedido
     * @return
     */
    @Override
    public ResponseEntity<?> savePedido(Pedido pedido) {
        this.pedidoRepository.save(pedido);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Pedido guardado."));
    }

    /**
     *
     * @param pedido
     * @return
     */
    @Override
    public ResponseEntity<?> updatePedido(Pedido pedido) {
        this.pedidoRepository.save(pedido);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Pedido actualizado."));
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<?> deletePedido(Long id) {
        this.pedidoRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Pedido borrado."));
    }
}
