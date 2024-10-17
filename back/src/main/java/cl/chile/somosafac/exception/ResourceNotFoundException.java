package cl.chile.somosafac.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public String resourceName;
    public String fieldName;
    public Object valueName;

    public ResourceNotFoundException (String resourceName, String fieldName, Object valueName){
        super(String.format("%s no encontrado con el %s : %s", resourceName, fieldName, valueName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.valueName = valueName;
    }

    public ResourceNotFoundException(String resourceName){
        super(String.format("No se encontraron registros de %s",resourceName));
        this.resourceName = resourceName;
    }

}
