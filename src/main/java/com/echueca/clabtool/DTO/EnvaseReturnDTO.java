package com.echueca.clabtool.DTO;

import com.echueca.clabtool.model.EnvaseProp;
import com.echueca.clabtool.model.Usuario;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class EnvaseReturnDTO {
    @Getter @Setter private long id;
    
    @Getter @Setter private double cantidad;
    @Getter @Setter private EnvaseProp propiedades;
    @Getter @Setter Usuario usuario;

    public EnvaseReturnDTO() {
    }

    public EnvaseReturnDTO(long id, double cantidad, EnvaseProp propiedades, Usuario usuario) {
        this.id = id;
        this.cantidad = cantidad;
        this.propiedades = propiedades;
        this.usuario = usuario;
    }
}