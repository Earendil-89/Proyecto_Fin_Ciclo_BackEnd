package com.echueca.clabtool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "roles")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Getter @Setter private ERol rol;

    public Rol(int id, ERol rol) {
        this.id = id;
        this.rol = rol;
    }

    public Rol() {
    }
}
