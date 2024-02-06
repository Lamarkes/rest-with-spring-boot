package br.com.lamarkes.restwithspringboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST) //sempre que for lançada a exception ela lança o status de bad request
public class UnsupportedMathOperationException extends RuntimeException {

    public UnsupportedMathOperationException(String ex){
        super(ex);
    }

    private static final long serialVersionUID = 1L;
}
