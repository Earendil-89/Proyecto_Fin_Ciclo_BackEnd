package com.echueca.clabtool.service.interfaces;

import com.echueca.clabtool.model.Pedido;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public interface IPedidoService {
    
    public List<Pedido> getPedido();
    
    public Pedido getPedidoById(Long id);
    
    public ResponseEntity<?> savePedido(Pedido pedido);
    
    public ResponseEntity<?> updatePedido(Pedido pedido);
    
    public ResponseEntity<?> deletePedido(Long id);
}
