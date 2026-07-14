package com.letsreadhere.recipeapi.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class APIException extends RuntimeException {
    private static final long serialVersionID = 1L;

    public APIException(String message) {
        super(String.format(message));
    }

}
