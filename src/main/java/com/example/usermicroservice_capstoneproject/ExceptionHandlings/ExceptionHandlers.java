package com.example.usermicroservice_capstoneproject.ExceptionHandlings;

import com.example.usermicroservice_capstoneproject.Exceptions.NoSuchUserException;
import com.example.usermicroservice_capstoneproject.dtos.NoSuchUserExceptionHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<NoSuchUserExceptionHandlerDTO> handleNoSuchUserException(NoSuchUserException noSuchUserException) {
        NoSuchUserExceptionHandlerDTO exceptionHandlerDTO = new NoSuchUserExceptionHandlerDTO();
        exceptionHandlerDTO.setMessage("No Such User found in DB.");
        return new ResponseEntity<>(exceptionHandlerDTO, HttpStatus.NOT_FOUND);
    }
}
