package com.echueca.clabtool.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "unidades")
public class Unidad {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Getter @Setter private EUnidad unidad;
    @NotBlank
    @Getter @Setter private String nombre;
    @NotBlank
    @Getter @Setter private String tipo;

    /**
     *
     */
    public Unidad() {
    }

    /**
     *
     * @param id
     * @param unidad
     * @param nombre
     * @param tipo
     */
    public Unidad(int id, EUnidad unidad, String nombre, String tipo) {
        this.id = id;
        this.unidad = unidad;
        this.nombre = nombre;
        this.tipo = tipo;
    }
}
