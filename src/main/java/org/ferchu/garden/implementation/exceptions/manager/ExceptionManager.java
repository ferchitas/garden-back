package org.ferchu.garden.implementation.exceptions.manager;

import org.ferchu.garden.generated.model.ErrorApp;
import org.ferchu.garden.implementation.exceptions.NotCreatedPlantTypeException;
import org.ferchu.garden.implementation.exceptions.UnexistingObjectException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionManager extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnexistingObjectException.class)
    public ResponseEntity<ErrorApp> manageUnexsistingObjectException(UnexistingObjectException ex) {

        return new ResponseEntity(ex.getErrorApp(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotCreatedPlantTypeException.class)
    public ResponseEntity<ErrorApp> manageNotCreatedPlantTypeException(NotCreatedPlantTypeException ex) {

        return new ResponseEntity(ex.getErrorApp(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ErrorApp> manageException(Exception ex) {

        ErrorApp errorApp = new ErrorApp();
//        errorApp
        ResponseEntity<ErrorApp> re = new ResponseEntity(errorApp, new HttpHeaders(), HttpStatus.NOT_FOUND);
        return re;
    }
}
