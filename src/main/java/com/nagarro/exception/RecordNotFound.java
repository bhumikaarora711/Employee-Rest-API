package com.nagarro.exception;
/*
 * @Author Bhumika_Arora
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecordNotFound(final String message) {
        super(message);
    }
}