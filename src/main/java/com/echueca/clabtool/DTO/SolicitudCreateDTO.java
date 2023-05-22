package com.echueca.clabtool.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class SolicitudCreateDTO {

    @Getter @Setter private String descripcion;
    @Getter @Setter private String codigoRecipiente;
    @Getter @Setter private String link;

    public SolicitudCreateDTO(String descripcion, String codigoRecipiente, String link) {
        this.descripcion = descripcion;
        this.codigoRecipiente = codigoRecipiente;
        this.link = link;
    }

    public SolicitudCreateDTO() {
    }
}
