package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.NotaEntity;
import cl.chile.somosafac.mapper.NotaMapper;
import cl.chile.somosafac.repository.NotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    public List<NotaDTO> getNotas() {
        List<NotaEntity> notas = notaRepository.findAll();
        return notas.stream()
                .map(notaMapper::notaToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NotaDTO getNota(Long id) {
        Optional<NotaEntity> nota = notaRepository.findById(id);
        return nota.map(notaMapper::notaToDto).orElse(null);
    }

    @Transactional
    public NotaDTO createNota(NotaDTO notaDTO) {
        NotaEntity nota = notaMapper.notaToEntity(notaDTO);
        NotaEntity nuevaNota = notaRepository.save(nota);
        return notaMapper.notaToDto(nuevaNota);
    }

    @Transactional
    public NotaDTO updateNota(Long id, NotaDTO notaDTO) {
        Optional<NotaEntity> notaExistente = notaRepository.findById(id);
        if (notaExistente.isPresent()) {
            NotaEntity nota = notaExistente.get();
            notaMapper.updateNotaFromDto(notaDTO, nota);
            NotaEntity notaActualizada = notaRepository.save(nota);
            return notaMapper.notaToDto(notaActualizada);
        }
        return null;
    }

    @Transactional
    public void deleteNota(Long id) {
        notaRepository.deleteById(id);
    }
}