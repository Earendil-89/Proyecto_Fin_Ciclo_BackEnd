/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.echueca.clabtool.DTO;

import com.echueca.clabtool.model.Usuario;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class SolicitudDTO {

    @Getter @Setter private Date fechaSolicitud;
    @Getter @Setter private String descripcion;
    @Getter @Setter private String codigoRecipiente;
    @Getter @Setter private String link;

    public SolicitudDTO(Date fechaSolicitud, String descripcion, String codigoRecipiente, String link) {
        this.fechaSolicitud = fechaSolicitud;
        this.descripcion = descripcion;
        this.codigoRecipiente = codigoRecipiente;
        this.link = link;
    }

    public SolicitudDTO() {
    }
}
