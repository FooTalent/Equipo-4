package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.UsuarioEntity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class FamiliaMapperManual {

    public static FamiliaDTO familiaToDto(FamiliaEntity familia) {
        FamiliaDTO dto = new FamiliaDTO();
        dto.setId(familia.getId());
        dto.setNombreFaUno(familia.getNombreFaUno());
        dto.setNombreFaDos(familia.getNombreFaDos());
        dto.setRutFaUno(familia.getRutFaUno());
        dto.setRutFaDos(familia.getRutFaDos());
        dto.setFechaNacimientoFaUno(familia.getFechaNacimientoFaUno());
        dto.setFechaNacimientoFaDos(familia.getFechaNacimientoFaDos());
        dto.setEstadoCivil(familia.getEstadoCivil());
        dto.setTelefono(familia.getTelefono());
        dto.setEmail(familia.getEmail());
        dto.setRegion(familia.getRegion());
        dto.setComuna(familia.getComuna());
        dto.setDireccion(familia.getDireccion());
        dto.setIngresoFa(familia.getIngresoFa());
        dto.setDuracionEvaluacion(familia.getDuracionEvaluacion());
        dto.setTiempoParaAcoger(familia.getTiempoParaAcoger());
        dto.setCantidadAcogimientos(familia.getCantidadAcogimientos());
        dto.setFechaInicioAcogimiento(familia.getFechaInicioAcogimiento());
        dto.setEdadNna(familia.getEdadNna());
        dto.setRangoEdadNna(familia.getRangoEdadNna());
        dto.setSexoNna(familia.getSexoNna());
        dto.setNacionalidadNna(familia.getNacionalidadNna());
        dto.setTiempoAcogimiento(familia.getTiempoAcogimiento());
        dto.setIngresoAfac(familia.getIngresoAfac());
        dto.setFechaUltimoContacto(familia.getFechaUltimoContacto());
        dto.setProgramaFundacionActual(familia.getProgramaFundacionActual());
        dto.setProgramaFundacionAnterior(familia.getProgramaFundacionAnterior());
        dto.setUsuarioCreacion(familia.getUsuarioCreacion());
        dto.setFechaCreacion(familia.getFechaCreacion().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        dto.setFechaModificacion(familia.getFechaModificacion().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        dto.setEstadoAcogimiento(familia.getEstadoAcogimiento());
        dto.setUsuario(familia.getUsuario().getId().toString());
        return dto;
    }

    public static FamiliaEntity familiaToEntity(FamiliaDTO familiaDTO) {
        FamiliaEntity familia = new FamiliaEntity();

        familia.setFechaCreacion(Date.from(familiaDTO.getFechaCreacion().atZone(ZoneId.systemDefault()).toInstant()));
        familia.setFechaModificacion(Date.from(familiaDTO.getFechaModificacion().atZone(ZoneId.systemDefault()).toInstant()));
        familia.setEstadoAcogimiento(familiaDTO.getEstadoAcogimiento());

        // Establecer la relación con UsuarioEntity
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(Long.parseLong(familiaDTO.getUsuario()));
        familia.setUsuario(usuario);

        return familia;
    }

    public static void updateFamiliaFromDto(FamiliaDTO familiaDTO, FamiliaEntity familia) {
        familia.setNombreFaUno(familiaDTO.getNombreFaUno());
        familia.setNombreFaDos(familiaDTO.getNombreFaDos());
        familia.setRutFaUno(familiaDTO.getRutFaUno());
        familia.setRutFaDos(familiaDTO.getRutFaDos());
        familia.setFechaNacimientoFaUno(familiaDTO.getFechaNacimientoFaUno());
        familia.setFechaNacimientoFaDos(familiaDTO.getFechaNacimientoFaDos());
        familia.setEstadoCivil(familiaDTO.getEstadoCivil());
        familia.setTelefono(familiaDTO.getTelefono());
        familia.setEmail(familiaDTO.getEmail());
        familia.setRegion(familiaDTO.getRegion());
        familia.setComuna(familiaDTO.getComuna());
        familia.setDireccion(familiaDTO.getDireccion());
        familia.setIngresoFa(familiaDTO.getIngresoFa());
        familia.setDuracionEvaluacion(familiaDTO.getDuracionEvaluacion());
        familia.setTiempoParaAcoger(familiaDTO.getTiempoParaAcoger());
        familia.setCantidadAcogimientos(familiaDTO.getCantidadAcogimientos());
        familia.setFechaInicioAcogimiento(familiaDTO.getFechaInicioAcogimiento());
        familia.setEdadNna(familiaDTO.getEdadNna());
        familia.setRangoEdadNna(familiaDTO.getRangoEdadNna());
        familia.setSexoNna(familiaDTO.getSexoNna());
        familia.setNacionalidadNna(familiaDTO.getNacionalidadNna());
        familia.setTiempoAcogimiento(familiaDTO.getTiempoAcogimiento());
        familia.setIngresoAfac(familiaDTO.getIngresoAfac());
        familia.setFechaUltimoContacto(familiaDTO.getFechaUltimoContacto());
        familia.setProgramaFundacionActual(familiaDTO.getProgramaFundacionActual());
        familia.setProgramaFundacionAnterior(familiaDTO.getProgramaFundacionAnterior());
        familia.setFechaModificacion(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        familia.setEstadoAcogimiento(familiaDTO.getEstadoAcogimiento());

        // Actualizar la relación con UsuarioEntity
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(Long.parseLong(familiaDTO.getUsuario()));
        familia.setUsuario(usuario);
    }
}