package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.DTO.PedidoSendDTO;
import com.echueca.clabtool.model.Pedido;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 * Interfaz que implementa los servicios de Pedido
 * @author Eduardo Chueca Montaner
 */
public interface IPedidoService {
    
    /**
     * Busca todos los pedidos de la base de datos
     * @return Lista con los pedidos
     */
    public List<Pedido> getPedido();
    
    /**
     * Busca todos los pedidos activos (sin fecha de entrega)
     * @return Lista con los pedidos
     */
    public List<Pedido> getActivePedido();
    
    /**
     * Busca todos los pedidos inactivos (con fecha de entrega)
     * @return Lista con los pedidos
     */
    public List<Pedido> getInactivePedido();
    
    /**
     * Busca un pedido por su numero ID
     * @param id ID del pedido
     * @return Pedido en caso satisfactorio, nulo en caso contrario
     */
    public Pedido getPedidoById(Long id);
    
    /**
     * Inserta un pedido nuevo en la base de datos
     * @param pedido Pedido a insertar
     * @return
     */
    public ResponseEntity<?> savePedido(PedidoSendDTO pedido);
    
    /**
     * Actualiza un pedido existente en la base de datos
     * @param pedido Pedido a actualizar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> updatePedido(Pedido pedido);
    
    /**
     * Elimina un pedido existente en la base de datos
     * @param id ID del pedido a eliminar
     * @return Mensaje de respuesta
     */
    public ResponseEntity<?> deletePedido(Long id);
}
