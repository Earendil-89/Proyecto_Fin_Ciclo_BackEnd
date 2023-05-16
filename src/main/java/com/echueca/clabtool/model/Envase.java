package com.echueca.clabtool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "envases")
public class Envase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    
    @Getter @Setter private double cantidad;
    @Getter @Setter private boolean disponible;
    
    @ManyToOne
    @Getter @Setter Estante estante;
    
    @ManyToOne
    @Getter @Setter EnvaseProp propiedades;
    
    @ManyToOne
    @Getter @Setter Pedido pedido;

    public Envase() {
    }

    public Envase(long id, double cantidad, boolean disponible, Estante estante, EnvaseProp propiedades, Pedido pedido) {
        this.id = id;
        this.cantidad = cantidad;
        this.disponible = disponible;
        this.estante = estante;
        this.propiedades = propiedades;
        this.pedido = pedido;
    }
}
