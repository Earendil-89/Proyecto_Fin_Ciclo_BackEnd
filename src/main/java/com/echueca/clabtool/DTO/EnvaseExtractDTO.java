package com.echueca.clabtool.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class EnvaseExtractDTO {
    
    @Getter @Setter private long id;
    @Getter @Setter private String nombreUsuario;
    @Getter @Setter private String razonUso;

    /**
     *
     * @param id
     * @param nombreUsuario
     * @param razonUso
     */
    public EnvaseExtractDTO(long id, String nombreUsuario, String razonUso) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.razonUso = razonUso;
    }

    /**
     *
     */
    public EnvaseExtractDTO() {
    }
}
