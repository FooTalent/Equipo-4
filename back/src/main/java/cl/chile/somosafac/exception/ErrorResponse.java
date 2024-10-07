package cl.chile.somosafac.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ErrorResponse {

    private String timestamp;
    private int status;
    private String message;
    private String error;
    private String path;
}
