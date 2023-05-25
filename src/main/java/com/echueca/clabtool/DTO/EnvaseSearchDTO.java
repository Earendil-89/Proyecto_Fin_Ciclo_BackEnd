package com.echueca.clabtool.DTO;

import com.echueca.clabtool.model.Compuesto;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class EnvaseSearchDTO {
    
    @Setter @Getter private long compuestoId;
    @Setter @Getter private String codigo;
    @Setter @Getter private String nombre;
    @Setter @Getter private double pureza;

    public EnvaseSearchDTO() {
    }

    public EnvaseSearchDTO(long compuestoId, String codigo, String nombre, double pureza) {
        this.compuestoId = compuestoId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.pureza = pureza;
    }
    
        public EnvaseSearchDTO(Long compuestoId, String codigo, String nombre, Double pureza) {
        this.compuestoId = compuestoId == null ? 0 : compuestoId.longValue();
        this.codigo = codigo == null ? "" : codigo;
        this.nombre = nombre == null ? "" : nombre;
        this.pureza = pureza == null ? 0.0 : pureza.doubleValue();
    } 
}
