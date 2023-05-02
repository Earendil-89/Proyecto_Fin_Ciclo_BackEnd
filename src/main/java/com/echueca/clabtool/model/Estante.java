package com.echueca.clabtool.model;

import javax.persistence.CascadeType;
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
@Table(name = "estantes")
public class Estante {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @Getter @Setter private String nombre;
    @ManyToOne(cascade = CascadeType.ALL)
    @Getter @Setter private Armario armario;
    @Getter @Setter private String descripcion;

    public Estante() {
    }

    public Estante(int id, String nombre, Armario armario, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.armario = armario;
        this.descripcion = descripcion;
    }
}