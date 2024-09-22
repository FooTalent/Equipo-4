package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-21T21:49:43-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class FamiliaMapperImpl implements FamiliaMapper {

    private final DatatypeFactory datatypeFactory;

    public FamiliaMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public FamiliaDTO familiaToDto(FamiliaEntity familia) {
        if ( familia == null ) {
            return null;
        }

        FamiliaDTO familiaDTO = new FamiliaDTO();

        familiaDTO.setId( familia.getId() );
        familiaDTO.setNombreFaUno( familia.getNombreFaUno() );
        familiaDTO.setNombreFaDos( familia.getNombreFaDos() );
        familiaDTO.setRutFaUno( familia.getRutFaUno() );
        familiaDTO.setRutFaDos( familia.getRutFaDos() );
        familiaDTO.setFechaNacimientoFaUno( familia.getFechaNacimientoFaUno() );
        familiaDTO.setFechaNacimientoFaDos( familia.getFechaNacimientoFaDos() );
        familiaDTO.setEstadoCivil( familia.getEstadoCivil() );
        familiaDTO.setTelefono( familia.getTelefono() );
        familiaDTO.setEmail( familia.getEmail() );
        familiaDTO.setRegion( familia.getRegion() );
        familiaDTO.setComuna( familia.getComuna() );
        familiaDTO.setDireccion( familia.getDireccion() );
        familiaDTO.setIngresoFa( familia.getIngresoFa() );
        familiaDTO.setDuracionEvaluacion( familia.getDuracionEvaluacion() );
        familiaDTO.setTiempoParaAcoger( familia.getTiempoParaAcoger() );
        familiaDTO.setCantidadAcogimientos( familia.getCantidadAcogimientos() );
        familiaDTO.setFechaInicioAcogimiento( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( familia.getFechaInicioAcogimiento() ) ) );
        familiaDTO.setEdadNna( familia.getEdadNna() );
        familiaDTO.setRangoEdadNna( familia.getRangoEdadNna() );
        familiaDTO.setSexoNna( familia.getSexoNna() );
        familiaDTO.setNacionalidadNna( familia.getNacionalidadNna() );
        familiaDTO.setTiempoAcogimiento( familia.getTiempoAcogimiento() );
        familiaDTO.setIngresoAfac( familia.getIngresoAfac() );
        familiaDTO.setFechaUltimoContacto( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( familia.getFechaUltimoContacto() ) ) );

        return familiaDTO;
    }

    @Override
    public FamiliaEntity familiaToEntity(FamiliaDTO familiaDTO) {
        if ( familiaDTO == null ) {
            return null;
        }

        FamiliaEntity familiaEntity = new FamiliaEntity();

        familiaEntity.setId( familiaDTO.getId() );
        familiaEntity.setNombreFaUno( familiaDTO.getNombreFaUno() );
        familiaEntity.setNombreFaDos( familiaDTO.getNombreFaDos() );
        familiaEntity.setRutFaUno( familiaDTO.getRutFaUno() );
        familiaEntity.setRutFaDos( familiaDTO.getRutFaDos() );
        familiaEntity.setFechaNacimientoFaUno( familiaDTO.getFechaNacimientoFaUno() );
        familiaEntity.setFechaNacimientoFaDos( familiaDTO.getFechaNacimientoFaDos() );
        familiaEntity.setEstadoCivil( familiaDTO.getEstadoCivil() );
        familiaEntity.setTelefono( familiaDTO.getTelefono() );
        familiaEntity.setEmail( familiaDTO.getEmail() );
        familiaEntity.setRegion( familiaDTO.getRegion() );
        familiaEntity.setComuna( familiaDTO.getComuna() );
        familiaEntity.setDireccion( familiaDTO.getDireccion() );
        familiaEntity.setIngresoFa( familiaDTO.getIngresoFa() );
        familiaEntity.setDuracionEvaluacion( familiaDTO.getDuracionEvaluacion() );
        familiaEntity.setTiempoParaAcoger( familiaDTO.getTiempoParaAcoger() );
        familiaEntity.setCantidadAcogimientos( familiaDTO.getCantidadAcogimientos() );
        familiaEntity.setFechaInicioAcogimiento( xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( familiaDTO.getFechaInicioAcogimiento() ) ) );
        familiaEntity.setEdadNna( familiaDTO.getEdadNna() );
        familiaEntity.setRangoEdadNna( familiaDTO.getRangoEdadNna() );
        familiaEntity.setSexoNna( familiaDTO.getSexoNna() );
        familiaEntity.setNacionalidadNna( familiaDTO.getNacionalidadNna() );
        familiaEntity.setTiempoAcogimiento( familiaDTO.getTiempoAcogimiento() );
        familiaEntity.setIngresoAfac( familiaDTO.getIngresoAfac() );
        familiaEntity.setFechaUltimoContacto( xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( familiaDTO.getFechaUltimoContacto() ) ) );

        return familiaEntity;
    }

    @Override
    public FamiliaDTO familiatoDto(FamiliaEntity familia) {
        if ( familia == null ) {
            return null;
        }

        FamiliaDTO familiaDTO = new FamiliaDTO();

        familiaDTO.setId( familia.getId() );
        familiaDTO.setNombreFaUno( familia.getNombreFaUno() );
        familiaDTO.setNombreFaDos( familia.getNombreFaDos() );
        familiaDTO.setRutFaUno( familia.getRutFaUno() );
        familiaDTO.setRutFaDos( familia.getRutFaDos() );
        familiaDTO.setFechaNacimientoFaUno( familia.getFechaNacimientoFaUno() );
        familiaDTO.setFechaNacimientoFaDos( familia.getFechaNacimientoFaDos() );
        familiaDTO.setEstadoCivil( familia.getEstadoCivil() );
        familiaDTO.setTelefono( familia.getTelefono() );
        familiaDTO.setEmail( familia.getEmail() );
        familiaDTO.setRegion( familia.getRegion() );
        familiaDTO.setComuna( familia.getComuna() );
        familiaDTO.setDireccion( familia.getDireccion() );
        familiaDTO.setIngresoFa( familia.getIngresoFa() );
        familiaDTO.setDuracionEvaluacion( familia.getDuracionEvaluacion() );
        familiaDTO.setTiempoParaAcoger( familia.getTiempoParaAcoger() );
        familiaDTO.setCantidadAcogimientos( familia.getCantidadAcogimientos() );
        familiaDTO.setFechaInicioAcogimiento( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( familia.getFechaInicioAcogimiento() ) ) );
        familiaDTO.setEdadNna( familia.getEdadNna() );
        familiaDTO.setRangoEdadNna( familia.getRangoEdadNna() );
        familiaDTO.setSexoNna( familia.getSexoNna() );
        familiaDTO.setNacionalidadNna( familia.getNacionalidadNna() );
        familiaDTO.setTiempoAcogimiento( familia.getTiempoAcogimiento() );
        familiaDTO.setIngresoAfac( familia.getIngresoAfac() );
        familiaDTO.setFechaUltimoContacto( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( familia.getFechaUltimoContacto() ) ) );

        return familiaDTO;
    }

    @Override
    public FamiliaEntity familiatoEntity(FamiliaDTO familiaDTO) {
        if ( familiaDTO == null ) {
            return null;
        }

        FamiliaEntity familiaEntity = new FamiliaEntity();

        familiaEntity.setId( familiaDTO.getId() );
        familiaEntity.setNombreFaUno( familiaDTO.getNombreFaUno() );
        familiaEntity.setNombreFaDos( familiaDTO.getNombreFaDos() );
        familiaEntity.setRutFaUno( familiaDTO.getRutFaUno() );
        familiaEntity.setRutFaDos( familiaDTO.getRutFaDos() );
        familiaEntity.setFechaNacimientoFaUno( familiaDTO.getFechaNacimientoFaUno() );
        familiaEntity.setFechaNacimientoFaDos( familiaDTO.getFechaNacimientoFaDos() );
        familiaEntity.setEstadoCivil( familiaDTO.getEstadoCivil() );
        familiaEntity.setTelefono( familiaDTO.getTelefono() );
        familiaEntity.setEmail( familiaDTO.getEmail() );
        familiaEntity.setRegion( familiaDTO.getRegion() );
        familiaEntity.setComuna( familiaDTO.getComuna() );
        familiaEntity.setDireccion( familiaDTO.getDireccion() );
        familiaEntity.setIngresoFa( familiaDTO.getIngresoFa() );
        familiaEntity.setDuracionEvaluacion( familiaDTO.getDuracionEvaluacion() );
        familiaEntity.setTiempoParaAcoger( familiaDTO.getTiempoParaAcoger() );
        familiaEntity.setCantidadAcogimientos( familiaDTO.getCantidadAcogimientos() );
        familiaEntity.setFechaInicioAcogimiento( xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( familiaDTO.getFechaInicioAcogimiento() ) ) );
        familiaEntity.setEdadNna( familiaDTO.getEdadNna() );
        familiaEntity.setRangoEdadNna( familiaDTO.getRangoEdadNna() );
        familiaEntity.setSexoNna( familiaDTO.getSexoNna() );
        familiaEntity.setNacionalidadNna( familiaDTO.getNacionalidadNna() );
        familiaEntity.setTiempoAcogimiento( familiaDTO.getTiempoAcogimiento() );
        familiaEntity.setIngresoAfac( familiaDTO.getIngresoAfac() );
        familiaEntity.setFechaUltimoContacto( xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( familiaDTO.getFechaUltimoContacto() ) ) );

        return familiaEntity;
    }

    @Override
    public void updateFamiliaFromDto(FamiliaDTO familiaDTO, FamiliaEntity familia) {
        if ( familiaDTO == null ) {
            return;
        }

        familia.setId( familiaDTO.getId() );
        familia.setNombreFaUno( familiaDTO.getNombreFaUno() );
        familia.setNombreFaDos( familiaDTO.getNombreFaDos() );
        familia.setRutFaUno( familiaDTO.getRutFaUno() );
        familia.setRutFaDos( familiaDTO.getRutFaDos() );
        familia.setFechaNacimientoFaUno( familiaDTO.getFechaNacimientoFaUno() );
        familia.setFechaNacimientoFaDos( familiaDTO.getFechaNacimientoFaDos() );
        familia.setEstadoCivil( familiaDTO.getEstadoCivil() );
        familia.setTelefono( familiaDTO.getTelefono() );
        familia.setEmail( familiaDTO.getEmail() );
        familia.setRegion( familiaDTO.getRegion() );
        familia.setComuna( familiaDTO.getComuna() );
        familia.setDireccion( familiaDTO.getDireccion() );
        familia.setIngresoFa( familiaDTO.getIngresoFa() );
        familia.setDuracionEvaluacion( familiaDTO.getDuracionEvaluacion() );
        familia.setTiempoParaAcoger( familiaDTO.getTiempoParaAcoger() );
        familia.setCantidadAcogimientos( familiaDTO.getCantidadAcogimientos() );
        familia.setFechaInicioAcogimiento( xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( familiaDTO.getFechaInicioAcogimiento() ) ) );
        familia.setEdadNna( familiaDTO.getEdadNna() );
        familia.setRangoEdadNna( familiaDTO.getRangoEdadNna() );
        familia.setSexoNna( familiaDTO.getSexoNna() );
        familia.setNacionalidadNna( familiaDTO.getNacionalidadNna() );
        familia.setTiempoAcogimiento( familiaDTO.getTiempoAcogimiento() );
        familia.setIngresoAfac( familiaDTO.getIngresoAfac() );
        familia.setFechaUltimoContacto( xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( familiaDTO.getFechaUltimoContacto() ) ) );
    }

    private XMLGregorianCalendar localDateToXmlGregorianCalendar( LocalDate localDate ) {
        if ( localDate == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendarDate(
            localDate.getYear(),
            localDate.getMonthValue(),
            localDate.getDayOfMonth(),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private XMLGregorianCalendar localDateTimeToXmlGregorianCalendar( LocalDateTime localDateTime ) {
        if ( localDateTime == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendar(
            localDateTime.getYear(),
            localDateTime.getMonthValue(),
            localDateTime.getDayOfMonth(),
            localDateTime.getHour(),
            localDateTime.getMinute(),
            localDateTime.getSecond(),
            localDateTime.get( ChronoField.MILLI_OF_SECOND ),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private static LocalDate xmlGregorianCalendarToLocalDate( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        return LocalDate.of( xcal.getYear(), xcal.getMonth(), xcal.getDay() );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }
}
