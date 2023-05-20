package com.echueca.clabtool.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email")
})
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;                // Clave principal
    
    @NotBlank
    @Size(max = 30)
    @Getter @Setter private String nombre;
    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String apellidos;
    @NotBlank
    @Size(max = 30)
    @Getter @Setter private String nombreUsuario;
    @NotBlank
    @Size(max = 30)
    @Getter @Setter private String email;

    public Usuario(long id, String nombre, String apellidos, String nombreUsuario, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
    }

    public Usuario() {
    }
}
