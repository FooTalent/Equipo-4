package cl.chile.somosafac.exception.custom;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(HttpStatus.CONFLICT)
@Data
public class ResourceAlreadyExistsException extends RuntimeException{

    private  String resourceName;
    private String fieldName;
    private Object valueName;

    public ResourceAlreadyExistsException (String resourceName, String fieldName, Object valueName){
        super(String.format("%s con el %s : %s ya existe", resourceName, fieldName, valueName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.valueName = valueName;
    }

}
