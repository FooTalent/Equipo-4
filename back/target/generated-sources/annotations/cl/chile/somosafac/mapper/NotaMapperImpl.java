package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.NotaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-22T18:40:44-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class NotaMapperImpl implements NotaMapper {

    @Override
    public NotaDTO notaToDto(NotaEntity nota) {
        if ( nota == null ) {
            return null;
        }

        NotaDTO notaDTO = new NotaDTO();

        notaDTO.setId( nota.getId() );
        notaDTO.setDescripcion( nota.getDescripcion() );
        notaDTO.setFechaCreacion( nota.getFechaCreacion() );

        return notaDTO;
    }

    @Override
    public NotaEntity notaToEntity(NotaDTO notaDTO) {
        if ( notaDTO == null ) {
            return null;
        }

        NotaEntity notaEntity = new NotaEntity();

        notaEntity.setId( notaDTO.getId() );
        notaEntity.setDescripcion( notaDTO.getDescripcion() );
        notaEntity.setFechaCreacion( notaDTO.getFechaCreacion() );

        return notaEntity;
    }

    @Override
    public void updateNotaFromDto(NotaDTO notaDTO, NotaEntity nota) {
        if ( notaDTO == null ) {
            return;
        }

        nota.setId( notaDTO.getId() );
        nota.setDescripcion( notaDTO.getDescripcion() );
        nota.setFechaCreacion( notaDTO.getFechaCreacion() );
    }
}
