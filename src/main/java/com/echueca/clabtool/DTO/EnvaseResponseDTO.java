package com.echueca.clabtool.DTO;

import com.echueca.clabtool.model.EnvaseProp;
import com.echueca.clabtool.model.Usuario;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class EnvaseResponseDTO {
    @Getter @Setter private long id;
    
    @Getter @Setter private double cantidad;
    @Getter @Setter private EnvaseProp propiedades;
    @Getter @Setter Usuario usuario;

    /**
     *
     */
    public EnvaseResponseDTO() {
    }

    /**
     *
     * @param id
     * @param cantidad
     * @param propiedades
     * @param usuario
     */
    public EnvaseResponseDTO(long id, double cantidad, EnvaseProp propiedades, Usuario usuario) {
        this.id = id;
        this.cantidad = cantidad;
        this.propiedades = propiedades;
        this.usuario = usuario;
    }
}