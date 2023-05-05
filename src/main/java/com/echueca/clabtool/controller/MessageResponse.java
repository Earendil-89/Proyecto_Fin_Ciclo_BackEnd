package com.echueca.clabtool.controller;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Eduardo Chueca Montaner
 */
public class MessageResponse {
    public static final int OK = 0;
    public static final int ALERT = 1;
    
    @Getter @Setter private int status;
    @Getter @Setter private String message;

    public MessageResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
