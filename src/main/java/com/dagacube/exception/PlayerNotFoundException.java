package com.dagacube.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(String message) {
        super(message);
    }
}
