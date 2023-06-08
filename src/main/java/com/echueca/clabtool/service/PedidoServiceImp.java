package com.echueca.clabtool.service;

import com.echueca.clabtool.DTO.PedidoSendDTO;
import com.echueca.clabtool.service.interfaces.IPedidoService;
import com.echueca.clabtool.controller.MessageResponse;
import com.echueca.clabtool.model.Envase;
import com.echueca.clabtool.model.Pedido;
import com.echueca.clabtool.model.Usuario;
import com.echueca.clabtool.repository.EnvaseRepository;
import com.echueca.clabtool.repository.PedidoRepository;
import com.echueca.clabtool.repository.UsuarioRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnvaseRepository envaseRepository;
    
    /**
     * Busca todos los pedidos de la base de datos
     * @return Lista con los pedidos
     */
    @Override
    public List<Pedido> getPedido() {
        return this.pedidoRepository.findAll();
    }

    /**
     * Busca todos los pedidos activos (sin fecha de entrega)
     * @return Lista con los pedidos
     */
    @Override
    public List<Pedido> getActivePedido() {
        return this.pedidoRepository.findByFechaEntregaIsNull();
    }
    
    /**
     * Busca todos los pedidos inactivos (con fecha de entrega)
     * @return Lista con los pedidos
     */
    public List<Pedido> getInactivePedido() {
        return this.pedidoRepository.findByFechaEntregaIsNotNull();
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
    public ResponseEntity<?> savePedido(PedidoSendDTO pedido) {
        Usuario usuario = this.usuarioRepository.findByNombreUsuario(pedido.getUserName());
        if( usuario == null ) {
            return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "Error: El usuario no existe"));
        }
        Pedido truePedido = pedido.getPedido();
        truePedido.setUsuario(usuario);
        if( truePedido.getFechaPedido() == null ) {
            truePedido.setFechaPedido(new Date());
        }
        this.pedidoRepository.save(truePedido);
        
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
        Optional<Pedido> testPedido = this.pedidoRepository.findById(id);
        if( testPedido.isEmpty() ) {
           return ResponseEntity.ok(new MessageResponse(MessageResponse.ALERT, "El pedido no existe")); 
        }
        List<Envase> envases = this.envaseRepository.findByPedido(testPedido.get());
        
        for(Envase e: envases) {
            e.setPedido(null);
            this.envaseRepository.save(e);
        }
        
        this.pedidoRepository.deleteById(id);
        
        return ResponseEntity.ok(new MessageResponse(MessageResponse.OK, "Pedido borrado."));
    }
}
