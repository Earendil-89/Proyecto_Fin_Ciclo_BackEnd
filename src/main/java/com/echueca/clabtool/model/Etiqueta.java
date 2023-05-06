package com.echueca.clabtool.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "etiquetas", uniqueConstraints = {
    @UniqueConstraint(columnNames = "codigo")
})
public class Etiqueta {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    @Getter @Setter private String codigo;
    @Getter @Setter private String descripcion;
    @Getter @Setter private String imgUrl;

    public Etiqueta() {
    }

    public Etiqueta(long id, String codigo, String descripcion, String imgUrl) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.imgUrl = imgUrl;
    }
}
