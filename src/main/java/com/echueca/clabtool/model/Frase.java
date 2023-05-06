package com.echueca.clabtool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "frases", uniqueConstraints = {
    @UniqueConstraint(columnNames = "codigo")
})
public class Frase {
    
    @Id
    @GeneratedValue()
    @Getter @Setter private long id;
    @Getter @Setter private String codigo;
    @Getter @Setter private String descripcion;

    public Frase() {
    }

    public Frase(long id, String codigo, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
