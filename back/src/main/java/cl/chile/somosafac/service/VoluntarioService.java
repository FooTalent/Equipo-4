package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.VoluntarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.entity.VoluntarioEntity;
import cl.chile.somosafac.exception.custom.ResourceNotFoundException;
import cl.chile.somosafac.mapper.VoluntarioMapperManual;
import cl.chile.somosafac.repository.VoluntarioRepository;
import cl.chile.somosafac.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;
    private final UsuarioRepository usuarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository, UsuarioRepository usuarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public VoluntarioDTO getVoluntario(Long id) {
        VoluntarioEntity voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntario","ID",id));
        return VoluntarioMapperManual.voluntarioToDto(voluntario);
    }

    public List<VoluntarioDTO> getAllVoluntarios() {
        List<VoluntarioEntity> voluntarios = voluntarioRepository.findAll();
        if (voluntarios.isEmpty()){
            throw new ResourceNotFoundException("Voluntarios");
        }
        return voluntarios.stream()
                .map(VoluntarioMapperManual::voluntarioToDto)
                .collect(Collectors.toList());
    }

    public VoluntarioDTO createVoluntario(VoluntarioDTO voluntarioDTO) {
        UsuarioEntity usuario = usuarioRepository.findById(voluntarioDTO.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario","ID",voluntarioDTO.getUsuarioId()));

        VoluntarioEntity voluntario = VoluntarioMapperManual.voluntarioToEntity(voluntarioDTO);
        voluntario.setUsuario(usuario);

        return VoluntarioMapperManual.voluntarioToDto(voluntarioRepository.save(voluntario));
    }

    public VoluntarioDTO updateVoluntario(Long id, VoluntarioDTO voluntarioDTO) {
        VoluntarioEntity voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntario","ID",voluntarioDTO.getUsuarioId()));

        VoluntarioMapperManual.updateVoluntarioFromDto(voluntarioDTO, voluntario);

        return VoluntarioMapperManual.voluntarioToDto(voluntarioRepository.save(voluntario));
    }

    public void deleteVoluntario(Long id) {
        VoluntarioEntity voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntario","ID",id));

        this.voluntarioRepository.deleteById(id);
    }
}