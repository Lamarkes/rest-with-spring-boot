package br.com.lamarkes.restwithspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //sempre que for lançada a exception ela lança o status de bad request
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String ex){
        super(ex);
    }
}
