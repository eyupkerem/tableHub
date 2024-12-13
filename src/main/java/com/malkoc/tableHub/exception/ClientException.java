package com.malkoc.tableHub.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ClientException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus httpStatus;

    public ClientException(String code) {
        this(code, HttpStatus.NOT_FOUND);
    }

    public ClientException(String code, HttpStatus httpStatus) {
        this.errorCode = code;
        this.httpStatus = httpStatus;
    }
}
