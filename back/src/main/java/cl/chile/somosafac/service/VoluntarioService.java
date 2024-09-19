package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.VoluntarioDTO;
import cl.chile.somosafac.entity.VoluntarioEntity;
import cl.chile.somosafac.mapper.VoluntarioMapper;
import cl.chile.somosafac.repository.VoluntarioRepository;
import org.springframework.stereotype.Service;


@Service
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;
    private final VoluntarioMapper voluntarioMapper;

    public VoluntarioService(VoluntarioRepository voluntarioRepository, VoluntarioMapper voluntarioMapper) {
        this.voluntarioRepository = voluntarioRepository;
        this.voluntarioMapper = voluntarioMapper;
    }

    public VoluntarioDTO getVoluntario(Long id) {
        VoluntarioEntity voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voluntario not found"));
        return voluntarioMapper.toDto(voluntario);
    }

    public VoluntarioEntity createVoluntario(VoluntarioDTO voluntarioDTO) {
        VoluntarioEntity voluntario = voluntarioMapper.toEntity(voluntarioDTO);
        return voluntarioRepository.save(voluntario);
    }

    public VoluntarioDTO updateVoluntario(Long id, VoluntarioDTO voluntarioDTO) {
        VoluntarioEntity voluntario = voluntarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voluntario not found"));
        voluntarioMapper.toEntity(voluntarioDTO);
        return voluntarioMapper.toDto(voluntarioRepository.save(voluntario));
    }

    public void deleteVoluntario(Long id) {
        voluntarioRepository.deleteById(id);
    }
}
