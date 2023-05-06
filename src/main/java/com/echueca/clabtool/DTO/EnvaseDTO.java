/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.echueca.clabtool.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class EnvaseDTO {
    @Getter @Setter private long id;
    
    @Getter @Setter private String codFabricante;
    @Getter @Setter private String nombre;
    @Getter @Setter private double pureza;
    @Getter @Setter private double cantidad;
    @Getter @Setter private double capacidad;
    @Getter @Setter private String unidades;

    public EnvaseDTO() {
    }

    public EnvaseDTO(long id, String codFabricante, String nombre, double pureza, double cantidad, double capacidad, String unidades) {
        this.id = id;
        this.codFabricante = codFabricante;
        this.nombre = nombre;
        this.pureza = pureza;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.unidades = unidades;
    }
}