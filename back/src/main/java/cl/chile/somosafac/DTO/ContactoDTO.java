package cl.chile.somosafac.DTO;

import cl.chile.somosafac.entity.ContactoEntity;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactoDTO {

    @NotNull(message = "El ID no puede ser nulo")
    private Long id;

    @NotNull(message = "La familia ID no puede ser nula")
    private FamiliaEntity familiaId;

    @NotNull(message = "El usuario ID no puede ser nulo")
    private UsuarioEntity usuarioId;

    @NotNull(message = "La fecha de contacto no puede ser nula")
    @PastOrPresent(message = "La fecha de contacto no puede ser futura")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaContacto;

    @NotBlank(message = "La descripción de contacto no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción de contacto debe tener entre 10 y 500 caracteres")
    private String descripcionContacto;


    //TODO VERIFICAR EL  dto.getFamiliaId().getId() y dto.getUsuarioId().getId() problemas con el Long
    public static ContactoDTO fromEntity(ContactoEntity contacto) {
        ContactoDTO dto = new ContactoDTO();
        dto.setId(contacto.getId());
        dto.setFamiliaId(contacto.getFamilia());
        dto.setUsuarioId(contacto.getUsuario());
        dto.setFechaContacto(contacto.getFechaContacto());
        dto.setDescripcionContacto(contacto.getDescripcionContacto());
        return dto;
    }
}