package cl.chile.somosafac.mapper;

import cl.chile.somosafac.DTO.ContactoDTO;
import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.ContactoEntity;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.NotificacionEntity;


public class ContactoMapperManual {

    public static ContactoDTO contactoToDto(ContactoEntity contacto) {
        ContactoDTO contactoDTO = new ContactoDTO();
        contactoDTO.setId(contacto.getId());
        contactoDTO.setFechaContacto(contacto.getFechaContacto());
//        contactoDTO.setFamiliaId(contacto.getFamilia().getId());
        contactoDTO.setFamiliaId(contacto.getFamilia()); // se quitó .getId()
        return contactoDTO;
    }

    public static ContactoEntity dtoToContacto(ContactoDTO contactoDTO) {
        ContactoEntity contacto = new ContactoEntity();
        contacto.setId(contactoDTO.getId());
        contacto.setFechaContacto(contactoDTO.getFechaContacto());
        return contacto;
    }

    public static FamiliaDTO familiaToDto(FamiliaEntity familia) {
        FamiliaDTO familiaDTO = new FamiliaDTO();
        familiaDTO.setId(familia.getId());
        familiaDTO.setNombreFaUno(familia.getNombreFaUno());
        familiaDTO.setNombreFaDos(familia.getNombreFaDos());
        return familiaDTO;
    }

    public static NotificacionDTO notificacionToDto(NotificacionEntity notificacion) {
        NotificacionDTO notificacionDTO = new NotificacionDTO();
        notificacionDTO.setId(notificacion.getId());
        notificacionDTO.setMensaje(notificacion.getMensaje());
        notificacionDTO.setVisto(notificacion.isVisto());
        return notificacionDTO;
    }

    public static NotificacionEntity dtoToNotificacion(NotificacionDTO notificacionDTO) {
        return null;
    }

    public static void updateContactoFromDto(ContactoDTO contactoDTO, ContactoEntity contactoEntity) {
    }
}