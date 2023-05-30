package com.echueca.clabtool.repository;

import com.echueca.clabtool.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Realiza consultas a la base de datos para realizar CRUD de pedidos
 * @author Eduardo Chueca Montaner
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
