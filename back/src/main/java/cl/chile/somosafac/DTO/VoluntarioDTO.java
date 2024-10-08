package cl.chile.somosafac.DTO;

import lombok.Data;

@Data

public class VoluntarioDTO {

    private Long id;
    private Long usuarioId;
    private String ocupacion;
    private String estadoVoluntario;

}

