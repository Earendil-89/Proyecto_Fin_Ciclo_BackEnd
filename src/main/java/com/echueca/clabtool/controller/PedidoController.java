package com.echueca.clabtool.controller;

import com.echueca.clabtool.model.Pedido;
import com.echueca.clabtool.repository.PedidoRepository;
import com.echueca.clabtool.service.interfaces.IPedidoService;
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
 *
 * @author Eduardo Chueca Montaner
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/clabtool")
public class PedidoController {
    
    @Autowired
    private IPedidoService pedidoService;
    
    @GetMapping("/pedido")
    public List<Pedido> getPedido() {
        return this.pedidoService.getPedido();
    }
    
    @GetMapping("/pedido/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        return this.pedidoService.getPedidoById(id);
    }
    
    @PostMapping("/pedido")
    public ResponseEntity<?> savePedido(@RequestBody Pedido pedido) {
        return this.pedidoService.savePedido(pedido);
    }
    
    @PutMapping("/pedido")
    public ResponseEntity<?> updatePedido(@RequestBody Pedido pedido) {
        return this.pedidoService.updatePedido(pedido);
    }
    
    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id) {
        return this.pedidoService.deletePedido(id);
    }
}
