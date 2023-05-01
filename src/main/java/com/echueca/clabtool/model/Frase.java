package com.echueca.clabtool.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "frases")
public class Frase {
    
    @Id
    @Getter @Setter private String codigo;
    @Getter @Setter private String descripcion;

    public Frase() {
    }

    public Frase(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
}
