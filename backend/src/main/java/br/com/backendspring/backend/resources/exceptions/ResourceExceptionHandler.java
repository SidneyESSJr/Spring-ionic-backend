package br.com.backendspring.backend.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.backendspring.backend.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e) {
        StandartError standartError = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standartError);
    }

}
