package io.github.letixs.sistemaVendas.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import io.github.letixs.sistemaVendas.exceptions.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErros(MethodArgumentNotValidException ex) {
	BindingResult bindingResult = ex.getBindingResult();
	List<String> message = bindingResult.getAllErrors()
		.stream()
		.map(objectError -> objectError.getDefaultMessage())
		.collect(Collectors.toList());
	return new ApiErrors(message);
    }
    
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrors> handleResponseStatusException(ResponseStatusException ex) {
	String mensagemErro = ex.getMessage();
	HttpStatus codigoStatus = ex.getStatus();
	ApiErrors apiErrors = new ApiErrors(mensagemErro);
	return new ResponseEntity<ApiErrors>(apiErrors, codigoStatus);
    }
    
}
