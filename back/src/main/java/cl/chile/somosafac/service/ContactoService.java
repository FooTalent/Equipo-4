package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.ContactoDTO;
import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.DTO.NotificacionDTO;
import cl.chile.somosafac.entity.ContactoEntity;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.NotificacionEntity;
import cl.chile.somosafac.mapper.ContactoMapperManual;
import cl.chile.somosafac.mapper.NotificacionMapperManual;
import cl.chile.somosafac.repository.ContactoRepository;
import cl.chile.somosafac.repository.FamiliaRepository;
import cl.chile.somosafac.repository.NotificacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactoService {

    private final ContactoRepository contactoRepository;
    private final FamiliaRepository familiaRepository;
    private final NotificacionRepository notificacionRepository;

    /**
     * Obtiene la lista de familias con sus contactos.
     */
    @Transactional(readOnly = true)
    public List<FamiliaDTO> listarFamiliasConContacto() {
        List<FamiliaEntity> familias = familiaRepository.findAll();
        return familias.stream()
                .map(familia -> {
                    FamiliaDTO familiaDTO = ContactoMapperManual.familiaToDto(familia);
                    familiaDTO.setHistorialContacto(familia.getHistorialContacto().stream()
                            .map(ContactoMapperManual::contactoToDto)
                            .toList());
                    return familiaDTO;
                })
                .toList();
    }

    /**
     * Obtiene el historial de contactos de una familia.
     */
    @Transactional(readOnly = true)
    public List<ContactoDTO> obtenerHistorialContactoFamilia(Long familiaId) {
        Optional<FamiliaEntity> familia = familiaRepository.findById(familiaId);
        if (familia.isPresent()) {
            List<ContactoEntity> contactos = contactoRepository.findByFamiliaId(familiaId);
            return contactos.stream().map(ContactoMapperManual::contactoToDto).toList();
        } else {
            return List.of();
        }
    }

    /**
     * Programa un nuevo contacto con una familia.
     */
    @Transactional
    public ContactoDTO programarContacto(ContactoDTO contactoDTO) {
        ContactoEntity contacto = new ContactoEntity();
        contacto.setFamilia(contactoDTO.getFamiliaId());
        contacto.setUsuario(contactoDTO.getUsuarioId());
        contacto.setFechaContacto(contactoDTO.getFechaContacto());
        contacto.setDescripcionContacto(contactoDTO.getDescripcionContacto());
        contactoRepository.save(contacto);

        // Programar recordatorios cada 3 meses
        List<NotificacionEntity> recordatorios = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            NotificacionEntity notificacion = new NotificacionEntity();
            notificacion.setUsuario(contactoDTO.getUsuarioId());
            notificacion.setMensaje("Recordatorio de contacto programado.");
            notificacion.setFechaEnvio(contactoDTO.getFechaContacto().plusMonths(3 * i));
            notificacion.setVisto(false);
            recordatorios.add(notificacion);
        }
        notificacionRepository.saveAll(recordatorios);

        return ContactoDTO.fromEntity(contacto);
    }

    /**
     * Obtiene las notificaciones pendientes.
     */
    @Transactional(readOnly = true)
    public List<NotificacionDTO> obtenerNotificacionesPendientes() {
        List<NotificacionEntity> notificaciones = notificacionRepository.findByVistoFalse();
        return notificaciones.stream().map(notificacion -> {
            NotificacionDTO notificacionDTO = NotificacionMapperManual.notificacionToDto(notificacion);
            notificacionDTO.setId(notificacion.getId());
            notificacionDTO.setMensaje(notificacion.getMensaje());
            notificacionDTO.setVisto(notificacion.isVisto());
            return notificacionDTO;
        }).toList();
    }

    /**
     * Marca una notificación como leída.
     */
    @Transactional
    public void marcarNotificacionComoLeida(Long notificacionId) {
        Optional<NotificacionEntity> notificacion = notificacionRepository.findById(notificacionId);
        notificacion.ifPresent(value -> {
            value.setVisto(true);
            notificacionRepository.save(value);
        });
    }

    /**
     * Elimina un contacto.
     */
    @Transactional
    public void eliminarContacto(Long contactoId) {
        contactoRepository.deleteById(contactoId);
    }

    /**
     * Actualiza un contacto.
     */
    @Transactional
    public ContactoDTO actualizarContacto(Long contactoId, ContactoDTO contactoDTO) {
        Optional<ContactoEntity> contacto = contactoRepository.findById(contactoId);
        if (contacto.isPresent()) {
            ContactoMapperManual.updateContactoFromDto(contactoDTO, contacto.get());
            ContactoEntity contactoActualizado = contactoRepository.save(contacto.get());
            return ContactoMapperManual.contactoToDto(contactoActualizado);
        } else {
            return null;
        }
    }

    /**
     * Obtiene un contacto por ID.
     *
     * @param contactoId ID del contacto.
     * @return ContactoDTO.
     */
    @Transactional(readOnly = true)
    public ContactoDTO obtenerContactoPorId(Long contactoId) {
        Optional<ContactoEntity> contacto = contactoRepository.findById(contactoId);
        return contacto.map(ContactoMapperManual::contactoToDto).orElse(null);
    }
}