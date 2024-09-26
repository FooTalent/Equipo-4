package cl.chile.somosafac.DTO;

import lombok.Data;

@Data

public class VoluntarioDTO {

    private Long id;
    private Long usuarioId;
    private String ocupacion;
    private String estadoVoluntario;

    /*public VoluntarioEntity toEntity(UsuarioEntity usuario){
        return VoluntarioEntity.builder()
                .id(this.id)
                .usuario(usuario)
                .ocupacion(this.ocupacion)
                .estadoVoluntario(this.estadoVoluntario)
                .build();
    }

    public  static VoluntarioDTO fromEntity(VoluntarioEntity voluntarioEntity){
        return VoluntarioDTO.builder()
                .id(voluntarioEntity.getId())
                .usuarioId(voluntarioEntity.getUsuario().getId())
                .ocupacion(voluntarioEntity.getOcupacion())
                .estadoVoluntario(voluntarioEntity.getEstadoVoluntario())
                .build();

    }*/
}

