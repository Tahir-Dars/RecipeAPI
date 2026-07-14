package com.letsreadhere.recipeapi.exceptions;

import com.letsreadhere.recipeapi.model.DTOs.API_ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerGlobally {
    @ExceptionHandler(APIException.class)
    public ResponseEntity<API_ResponseDTO> API_ExceptionMethod(APIException e) {
        API_ResponseDTO responses = new API_ResponseDTO(e.getMessage(), false);
        return new ResponseEntity<>(responses, HttpStatus.BAD_REQUEST);
    }
}
