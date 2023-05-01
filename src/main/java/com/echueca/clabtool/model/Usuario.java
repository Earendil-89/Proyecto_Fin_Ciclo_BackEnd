package com.echueca.clabtool.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Getter @Setter private String dni;
    
    @NotBlank
    @Size(max = 20)
    @Getter @Setter private String nombre;
    @NotBlank
    @Size(max = 30)
    @Getter @Setter private String apellidos;
    @NotBlank
    @Size(max = 30)
    @Getter @Setter private String email;
    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String password;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "roles_usuarios", 
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "rol_id"))
    @Getter @Setter private Set<Rol> roles = new HashSet<>();

    public Usuario(String dni, String nombre, String apellidos, String email, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }

    public Usuario() {
    }
}
