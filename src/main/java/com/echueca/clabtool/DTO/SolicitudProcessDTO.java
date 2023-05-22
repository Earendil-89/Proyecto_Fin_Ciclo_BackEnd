package com.echueca.clabtool.DTO;

import com.echueca.clabtool.model.EstadoSolicitud;
import com.echueca.clabtool.model.Usuario;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class SolicitudProcessDTO {
    

    @Getter @Setter private long id;
    @Getter @Setter private EstadoSolicitud estado;

    public SolicitudProcessDTO() {
    }

    public SolicitudProcessDTO(long id, EstadoSolicitud estado) {
        this.id = id;
        this.estado = estado;
    }
}
