package io.github.letixs.sistemaVendas.exceptions;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    private List<String> errors;

    public List<String> getErrors() {
        return errors;
    }

    public ApiErrors(List<String> errors) {
	this.errors = errors;
    }
    
    public ApiErrors(String messages) {
	this.errors = Arrays.asList(messages);
    }
    
}
