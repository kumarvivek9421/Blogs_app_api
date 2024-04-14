package com.blog_app_apis.exception;

import com.blog_app_apis.payload.ApiResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponce> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        String massage= ex.getMessage();

        ApiResponce apiResponce= new ApiResponce(massage, false);
        return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){

       Map<String, String> errors= new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((err)->{
          String fieldName= ((FieldError)err).getField();
          String message= err.getDefaultMessage();
          errors.put(fieldName, message);
       });
        return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
    }
}
