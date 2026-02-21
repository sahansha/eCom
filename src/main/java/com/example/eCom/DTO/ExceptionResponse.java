package com.example.eCom.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {
    private String apiPath;
    private String errorMessage;
    private HttpStatus errorCode;
    private LocalDateTime errorTime;

    public ExceptionResponse() {
    }


    public ExceptionResponse(String description, String message, HttpStatus httpStatus, LocalDateTime now) {
        this.errorTime = errorTime;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.apiPath = apiPath;
    }
}
