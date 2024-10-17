package cl.chile.somosafac.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistsException extends RuntimeException{

    public String resourceName;
    public String fieldName;
    public Object valueName;

    public ResourceAlreadyExistsException (String resourceName, String fieldName, Object valueName){
        super(String.format("%s con el %s : %s ya existe", resourceName, fieldName, valueName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.valueName = valueName;
    }

}
