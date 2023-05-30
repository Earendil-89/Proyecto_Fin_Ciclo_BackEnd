package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Pedido;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IPedidoService {
    
    /**
     *
     * @return
     */
    public List<Pedido> getPedido();
    
    /**
     *
     * @param id
     * @return
     */
    public Pedido getPedidoById(Long id);
    
    /**
     *
     * @param pedido
     * @return
     */
    public ResponseEntity<?> savePedido(Pedido pedido);
    
    /**
     *
     * @param pedido
     * @return
     */
    public ResponseEntity<?> updatePedido(Pedido pedido);
    
    /**
     *
     * @param id
     * @return
     */
    public ResponseEntity<?> deletePedido(Long id);
}
