package com.echueca.clabtool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
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
    @Getter @Setter private long id;
    @NotBlank
    @Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    
    @NotBlank
    @ManyToOne
    @Getter @Setter private Armario armario;

    /**
     *
     */
    public Estante() {
    }

    /**
     *
     * @param id
     * @param nombre
     * @param descripcion
     * @param armario
     */
    public Estante(long id, String nombre, String descripcion, Armario armario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.armario = armario;
    }
}