package cl.chile.somosafac.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFormatException extends RuntimeException {

    public InvalidFormatException(String message){
        super(message);
    }
}
