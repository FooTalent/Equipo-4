package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.NotaEntity;
import cl.chile.somosafac.mapper.NotaMapper;
import cl.chile.somosafac.repository.FamiliaRepository;
import cl.chile.somosafac.repository.NotaRepository;
import cl.chile.somosafac.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaService {
    private final NotaRepository notaRepository;
    private final NotaMapper notaMapper;

    public NotaService(NotaRepository notaRepository, NotaMapper notaMapper) {
        this.notaRepository = notaRepository;
        this.notaMapper = notaMapper;
    }

    public NotaDTO getNota(Long id) {
        NotaEntity nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota not found"));
        return notaMapper.toDto(nota);
    }

    public NotaEntity createNota(NotaDTO notaDTO) {
        NotaEntity nota = notaMapper.toEntity(notaDTO);
        return notaRepository.save(nota);
    }

    public NotaDTO updateNota(Long id, NotaDTO notaDTO) {
        NotaEntity nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota not found"));
        notaMapper.toEntity(notaDTO);
        return notaMapper.toDto(notaRepository.save(nota));
    }

    public void deleteNota(Long id) {
        notaRepository.deleteById(id);
    }
}

