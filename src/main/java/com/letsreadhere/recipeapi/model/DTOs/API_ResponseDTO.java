package com.letsreadhere.recipeapi.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class API_ResponseDTO {
    public String message;
    public boolean status;
}
