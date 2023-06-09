package com.echueca.clabtool.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    
    @NotBlank
    @Getter @Setter private double importe;
    
    @NotBlank
    @Temporal(TemporalType.DATE)
    @Getter @Setter private Date fechaPedido;
    
    @Temporal(TemporalType.DATE)
    @Getter @Setter private Date fechaEntrega;
    
    @NotBlank
    @Getter @Setter private String factura;
    
    @NotBlank
    @ManyToOne
    @Getter @Setter private Usuario usuario;

    /**
     *
     */
    public Pedido() {
    }

    /**
     *
     * @param id
     * @param importe
     * @param fechaPedido
     * @param fechaEntrega
     * @param factura
     * @param usuario
     */
    public Pedido(long id, double importe, Date fechaPedido, Date fechaEntrega, String factura, Usuario usuario) {
        this.id = id;
        this.importe = importe;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.factura = factura;
        this.usuario = usuario;
    }
}