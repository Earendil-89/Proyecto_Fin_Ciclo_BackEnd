package com.echueca.clabtool.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "recipientes")
public class Envase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    
    @Getter @Setter private String codFabricante;
    @Getter @Setter private String nombre;
    @Getter @Setter private double pureza;
    @Getter @Setter private double cantidad;
    @Getter @Setter private double capacidad;
    
    @Enumerated(EnumType.STRING)
    @Getter @Setter private Unidad unidades;
    @Getter @Setter private boolean disponible;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @Getter @Setter Estante estante;

    public Envase() {
    }

    public Envase(long id, String codFabricante, String nombre, long pureza, long cantidad, long capacidad, Unidad unidades, boolean disponible, Estante estante) {
        this.id = id;
        this.codFabricante = codFabricante;
        this.nombre = nombre;
        this.pureza = pureza;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.unidades = unidades;
        this.disponible = disponible;
        this.estante = estante;
    }
}
