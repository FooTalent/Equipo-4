package cl.chile.somosafac.exception.custom;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@EqualsAndHashCode(callSuper = true)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Object valueName;

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
