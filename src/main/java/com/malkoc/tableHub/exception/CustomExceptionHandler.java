package com.malkoc.tableHub.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = ClientException.class)
    public ResponseEntity<ClientException> handleClientException(ClientException clientException) {
        return new ResponseEntity<>(clientException.getHttpStatus());
    }

}
