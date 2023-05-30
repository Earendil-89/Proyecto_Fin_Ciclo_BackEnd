package com.echueca.clabtool.model;

import com.echueca.clabtool.DTO.SolicitudCreateDTO;
import com.echueca.clabtool.DTO.SolicitudProcessDTO;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
@Entity
@Table(name = "solicitudes")
public class Solicitud {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;
    
    @NotBlank
    @Temporal(TemporalType.DATE)
    @Getter @Setter private Date fechaSolicitud;
    
    @NotBlank
    @ManyToOne
    @Getter @Setter private Usuario usuarioSolicitud;
    
    @Temporal(TemporalType.DATE)
    @Getter @Setter private Date fechaTramite;
    @ManyToOne
    @Getter @Setter private Usuario usuarioTramite;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Getter @Setter private EstadoSolicitud estado;
    
    @Column(length = 400) 
    @Getter @Setter private String descripcion;
    
    @NotBlank
    @Getter @Setter private String codigoRecipiente;
    
    @Getter @Setter private String link;

    /**
     *
     */
    public Solicitud() {
    }

    /**
     *
     * @param id
     * @param fechaSolicitud
     * @param usuarioSolicitud
     * @param fechaTramite
     * @param usuarioTramite
     * @param estado
     * @param descripcion
     * @param idRecipiente
     * @param link
     */
    public Solicitud(long id, Date fechaSolicitud, Usuario usuarioSolicitud, Date fechaTramite, Usuario usuarioTramite, EstadoSolicitud estado, String descripcion, String idRecipiente, String link) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.usuarioSolicitud = usuarioSolicitud;
        this.fechaTramite = fechaTramite;
        this.usuarioTramite = usuarioTramite;
        this.estado = estado;
        this.descripcion = descripcion;
        this.codigoRecipiente = codigoRecipiente;
        this.link = link;
    }
    
    /**
     *
     * @param dto
     */
    public Solicitud(SolicitudCreateDTO dto) {
        this.fechaSolicitud = new Date();
        this.estado = EstadoSolicitud.ESTADO_ESPERA;
        this.descripcion = dto.getDescripcion();
        this.codigoRecipiente = dto.getCodigoRecipiente();
        this.link = dto.getLink();
    }
}