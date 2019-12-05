package com.jeff.mrfilm.errors;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiError {
 
    private HttpStatus status;
    private List<String> errors;
 
    public ApiError(HttpStatus status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }
 
    public ApiError(HttpStatus status, String error) {
        this.status = status;
        this.errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
