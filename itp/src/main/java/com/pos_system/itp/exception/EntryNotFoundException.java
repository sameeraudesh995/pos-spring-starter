package com.pos_system.itp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntryNotFoundException extends RuntimeException{

    public EntryNotFoundException(String message){
        super(message);
    }
}
