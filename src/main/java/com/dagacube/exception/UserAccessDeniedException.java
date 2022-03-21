package com.dagacube.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
@ResponseBody
public class UserAccessDeniedException extends RuntimeException{

    public UserAccessDeniedException(String message) {
        super(message);
    }
}
