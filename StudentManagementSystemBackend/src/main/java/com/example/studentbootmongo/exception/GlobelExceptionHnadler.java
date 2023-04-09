package com.example.studentbootmongo.exception;


import com.example.studentbootmongo.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHnadler {

    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHnadler(ResourceNotFoundExceptions ex){
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(FieldNotEmpty.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHnadler(FieldNotEmpty ex){
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UserInActive.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHnadler(UserInActive ex){
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }


}


