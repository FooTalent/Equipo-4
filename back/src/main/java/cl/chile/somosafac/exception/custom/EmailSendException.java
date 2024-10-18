package cl.chile.somosafac.exception.custom;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@Data
public class EmailSendException extends RuntimeException {

    private String email;
    public EmailSendException(String message, String email,  Throwable causa){
        super(String.format("%s con el Email: %s / causa: %s",message,email,causa));
        this.email = email;
    }
}