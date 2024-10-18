package cl.chile.somosafac.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TemplateNotFoundException extends RuntimeException {

    public TemplateNotFoundException (String message){
        super(message);
    }

}
