package com.echueca.clabtool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "compuestos", uniqueConstraints = {
    @UniqueConstraint(columnNames = "cas")
})
public class Compuesto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter long id;
    
    @Getter @Setter private String cas;
    
    @NotBlank
    @Getter @Setter private String nombre;
    
    @Getter @Setter private String nombreSecundario;
    @Getter @Setter private String formula;
    @Getter @Setter private double pesoMolecular;
    @Getter @Setter private String imgUrl;

    public Compuesto() {
    }

    public Compuesto(long id, String cas, String nombre, String nombreSecundario, String formula, double pesoMolecular, String imgUrl) {
        this.id = id;
        this.cas = cas;
        this.nombre = nombre;
        this.nombreSecundario = nombreSecundario;
        this.formula = formula;
        this.pesoMolecular = pesoMolecular;
        this.imgUrl = imgUrl;
    }
}
