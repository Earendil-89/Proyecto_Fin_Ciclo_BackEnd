package com.echueca.clabtool.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que devuelve un estado de la operación y un mensaje
 * @author Eduardo Chueca Montaner
 */
public class MessageResponse {

    /**
     * Estado que indica que la operación se realizó correctamente.
     */
    public static final int OK = 0;

    /**
     * Estado que indica que hubo un error y la operación se canceló para evitar excepciones
     */
    public static final int ALERT = 1;
    
    @Getter @Setter private int status;
    @Getter @Setter private String message;

    /**
     *
     * @param status Estado del mensaje
     * @param message Contenido del mensaje
     */
    public MessageResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
