package com.zhelezov.unikoom.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResourceNotFoundException  extends RuntimeException {

    private final HttpStatus code;

    public ResourceNotFoundException(String message) {
        super(message);
        code = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ResourceNotFoundException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }
}
