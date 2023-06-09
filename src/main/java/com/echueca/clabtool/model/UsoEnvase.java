package com.echueca.clabtool.model;

import java.util.Date;
import javax.persistence.CascadeType;
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
@Table(name = "uso_envases")
public class UsoEnvase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id; 
    
    @NotBlank
    @ManyToOne
    @Getter @Setter private Usuario usuario;
    @NotBlank
    @ManyToOne
    @Getter @Setter private Envase envase;
    
    @Temporal(TemporalType.TIMESTAMP) @NotBlank
    @Getter @Setter private Date fechaUso;
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date fechaDevolucion;
    @Getter @Setter private String razonUso;
    @Getter @Setter private String comentarios;
    @Getter @Setter private double cantidadUsada;
    @Getter @Setter private boolean agotado;

    /**
     *
     */
    public UsoEnvase() {
    }

    /**
     *
     * @param id
     * @param usuario
     * @param envase
     * @param fechaUso
     * @param fechaDevolucion
     * @param razonUso
     * @param comentarios
     * @param cantidadUsada
     * @param agotado
     */
    public UsoEnvase(long id, Usuario usuario, Envase envase, Date fechaUso, Date fechaDevolucion, String razonUso, String comentarios, double cantidadUsada, boolean agotado) {
        this.id = id;
        this.usuario = usuario;
        this.envase = envase;
        this.fechaUso = fechaUso;
        this.fechaDevolucion = fechaDevolucion;
        this.razonUso = razonUso;
        this.comentarios = comentarios;
        this.cantidadUsada = cantidadUsada;
        this.agotado = agotado;
    }
}