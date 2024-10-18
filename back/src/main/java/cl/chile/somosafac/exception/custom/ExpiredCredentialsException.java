package cl.chile.somosafac.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ExpiredCredentialsException extends RuntimeException{

    public ExpiredCredentialsException(String message){
        super(message);
    }
}
