package com.echueca.clabtool.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name ="propiedades_envase", uniqueConstraints = {
    @UniqueConstraint(columnNames = "codigo")
})
public class EnvaseProp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    
    @NotBlank
    @Getter @Setter private String codigo;
    @NotBlank
    @Getter @Setter private String nombre;
    @Getter @Setter private double pureza;
    @NotBlank
    @Getter @Setter private double capacidad;
    
    @NotBlank
    @ManyToOne
    @Getter @Setter private Compuesto compuesto;
    
    @ManyToMany
    @JoinTable(	name = "envases_frases", 
        joinColumns = @JoinColumn(name = "envase_id"), 
        inverseJoinColumns = @JoinColumn(name = "frase_id"))
    @Getter @Setter private Set<Frase> frases;
    
    @ManyToMany
    @JoinTable(	name = "envases_etiquetas", 
        joinColumns = @JoinColumn(name = "envase_id"), 
        inverseJoinColumns = @JoinColumn(name = "etiqueta_id"))
    @Getter @Setter private Set<Etiqueta> etiquetas;
    @Getter @Setter private String urlFabricante;
    
    @NotBlank
    @ManyToOne
    @Getter @Setter private Unidad unidades;

    public EnvaseProp() {
    }

    public EnvaseProp(long id, String codigo, String nombre, double pureza, double capacidad, Unidad unidades, Compuesto compuesto, Set<Frase> frases, Set<Etiqueta> etiquetas, String urlFabricante) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.pureza = pureza;
        this.capacidad = capacidad;
        this.unidades = unidades;
        this.compuesto = compuesto;
        this.frases = frases;
        this.etiquetas = etiquetas;
        this.urlFabricante = urlFabricante;
    }
}
