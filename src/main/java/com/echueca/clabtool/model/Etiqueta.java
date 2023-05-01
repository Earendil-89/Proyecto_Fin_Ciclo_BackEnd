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
@Table(name = "etiquetas")
public class Etiqueta {
   
    @Id
    @Getter @Setter private String codigo;
    @Getter @Setter private String descripcion;
    @Getter @Setter private String imgUrl;

    public Etiqueta() {
    }

    public Etiqueta(String codigo, String descripcion, String imgUrl) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
    }
}
