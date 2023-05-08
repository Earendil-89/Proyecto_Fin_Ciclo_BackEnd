package com.echueca.clabtool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name ="propiedades_envase")
public class EnvaseProp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    
    @Getter @Setter private String codigo;
    @Getter @Setter private String nombre;
    @Getter @Setter private double pureza;
    @Getter @Setter private double cantidad;
    @Getter @Setter private Unidad unidades;
    @OneToOne
    @Getter @Setter private Compuesto compuesto;

    public EnvaseProp() {
    }

    public EnvaseProp(long id, String codigo, String nombre, double pureza, double cantidad, Unidad unidades, Compuesto compuesto) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.pureza = pureza;
        this.cantidad = cantidad;
        this.unidades = unidades;
        this.compuesto = compuesto;
    }
}
