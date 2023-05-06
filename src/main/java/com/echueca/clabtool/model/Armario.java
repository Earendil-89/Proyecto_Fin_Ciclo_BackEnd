package com.echueca.clabtool.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL)
    @Getter @Setter private List<Estante> estantes;

    public Armario() {
    }

    public Armario(int id, String nombre, String descripcion, List<Estante> estantes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estantes = List.copyOf(estantes);
    }
}
