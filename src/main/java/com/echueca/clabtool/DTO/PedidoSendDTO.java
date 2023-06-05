package com.echueca.clabtool.DTO;

import com.echueca.clabtool.model.Pedido;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class PedidoSendDTO {
    @Getter @Setter private Pedido pedido;
    @Getter @Setter private String userName;

    public PedidoSendDTO() {
    }

    public PedidoSendDTO(Pedido pedido, String userName) {
        this.pedido = pedido;
        this.userName = userName;
    }
}
