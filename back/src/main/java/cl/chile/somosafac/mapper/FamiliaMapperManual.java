package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.UsuarioEntity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class FamiliaMapperManual {

    // Conversión de FamiliaEntity a FamiliaDTO
    public static FamiliaDTO familiaToDto(FamiliaEntity familia) {
        if (familia == null) {
            return null; // o lanza una excepción
        }
        FamiliaDTO familiaDTO = new FamiliaDTO();
        familiaDTO.setId(familia.getId());
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

        // Manejo de fechas
        if (familia.getFechaCreacion() != null) {
            dto.setFechaCreacion(familia.getFechaCreacion().atZone(ZoneId.systemDefault()).toLocalDateTime());
        }
        if (familia.getFechaModificacion() != null) {
            dto.setFechaModificacion(familia.getFechaModificacion().atZone(ZoneId.systemDefault()).toLocalDateTime());
        }

        dto.setEstadoAcogimiento(familia.getEstadoAcogimiento());

        // Manejo del usuario
        if (familia.getUsuario() != null) {
            dto.setUsuario(Long.valueOf(familia.getUsuario().getId().toString()));
        } else {
            dto.setUsuario(null); // o algún valor por defecto
        }

        return dto;
    }

    // Conversión de FamiliaDTO a FamiliaEntity
    public static FamiliaEntity familiaToEntity(FamiliaDTO familiaDTO) {
        FamiliaEntity familia = new FamiliaEntity();

        // Manejo de fechas
        if (familiaDTO.getFechaCreacion() != null) {
            familia.setFechaCreacion(LocalDateTime.from(familiaDTO.getFechaCreacion().atZone(ZoneId.systemDefault()).toInstant()));
        }
        if (familiaDTO.getFechaModificacion() != null) {
            familia.setFechaModificacion(LocalDateTime.from(familiaDTO.getFechaModificacion().atZone(ZoneId.systemDefault()).toInstant()));
        }

        familia.setEstadoAcogimiento(familiaDTO.getEstadoAcogimiento());

        // Establecer la relación con UsuarioEntity
        UsuarioEntity usuario = new UsuarioEntity();
        try {
            usuario.setId(Long.parseLong(String.valueOf(familiaDTO.getUsuario())));
        } catch (NumberFormatException e) {
            // Manejar la excepción
        }
        familia.setUsuario(usuario);

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
        familia.setUsuarioCreacion(familiaDTO.getUsuarioCreacion());

        return familia;
    }

    // Actualización de FamiliaEntity desde FamiliaDTO
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

        // Actualizar fecha de modificación
        familia.setFechaModificacion(LocalDateTime.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        // Actualizar estado de acogimiento
        familia.setEstadoAcogimiento(familiaDTO.getEstadoAcogimiento());

        // Actualizar la relación con UsuarioEntity
        UsuarioEntity usuario = new UsuarioEntity();
        try {
            usuario.setId(Long.parseLong(String.valueOf(familiaDTO.getUsuario())));
        } catch (NumberFormatException e) {
            // Manejar la excepción
        }
        familia.setUsuario(usuario);
    }
}