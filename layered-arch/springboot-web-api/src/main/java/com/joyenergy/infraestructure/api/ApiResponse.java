package com.joyenergy.infraestructure.api;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private T data;

    private ErrorResponse error;


    public ApiResponse() {
    }

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(ErrorResponse error) {
        this.error = error;
    }

    public ApiResponse(T data, ErrorResponse error) {
        this.data = data;
        this.error = error;
    }

}
