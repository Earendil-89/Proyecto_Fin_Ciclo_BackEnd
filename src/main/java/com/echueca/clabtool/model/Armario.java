package com.echueca.clabtool.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import static org.hibernate.engine.internal.Cascade.cascade;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "armarios")
public class Armario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    @Getter @Setter private String nombre;
}
