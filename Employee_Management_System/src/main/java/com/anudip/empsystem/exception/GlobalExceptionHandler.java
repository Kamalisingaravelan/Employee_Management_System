package com.anudip.empsystem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<?> handleNotFound(ResourceNotFoundException ex) {
	        Map<String,String> m = new HashMap<>();
	        m.put("error", ex.getMessage());
	        return new ResponseEntity<>(m, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(IllegalArgumentException.class)
	    public ResponseEntity<?> handleBadArg(IllegalArgumentException ex) {
	        Map<String,String> m = new HashMap<>();
	        m.put("error", ex.getMessage());
	        return new ResponseEntity<>(m, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> handleGeneral(Exception ex) {
	        Map<String,String> m = new HashMap<>();
	        m.put("error", ex.getMessage());
	        return new ResponseEntity<>(m, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
	        Map<String,String> errors = new HashMap<>();
	        for (FieldError err : ex.getBindingResult().getFieldErrors()) {
	            errors.put(err.getField(), err.getDefaultMessage());
	        }
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
}
