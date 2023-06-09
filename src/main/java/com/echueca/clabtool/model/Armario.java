package com.echueca.clabtool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "armarios")
public class Armario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    @NotBlank
    @Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    
    /**
     *
     */
    public Armario() {
    }

    /**
     *
     * @param id
     * @param nombre
     * @param descripcion
     */
    public Armario(long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
