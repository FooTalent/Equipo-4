package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.NotaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.NotaEntity;
import cl.chile.somosafac.entity.VoluntarioEntity;
import cl.chile.somosafac.mapper.NotaMapperManual;
import cl.chile.somosafac.repository.NotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @Transactional(readOnly = true)
    public List<NotaDTO> getNotas() {
        List<NotaEntity> notas = notaRepository.findAll();
        return notas.stream()
                .map(NotaMapperManual::notaToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public NotaDTO getNota(Long id) {
        NotaEntity nota = notaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nota " + id + " no encontrada"));

        return NotaMapperManual.notaToDto(nota);
    }

    @Transactional
    public NotaDTO createNota(NotaDTO notaDTO, FamiliaEntity familia, VoluntarioEntity voluntario) {
        NotaEntity nota = NotaMapperManual.notaToEntity(notaDTO, familia, voluntario);
        NotaEntity nuevaNota = notaRepository.save(nota);
        return NotaMapperManual.notaToDto(nuevaNota);
    }

    @Transactional
    public NotaDTO updateNota(Long id, NotaDTO notaDTO, FamiliaEntity familia, VoluntarioEntity voluntario) {
        NotaEntity nota = notaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nota " + id + " no encontrada"));

        nota.setDescripcion(notaDTO.getDescripcion());
        if(familia != null){
            nota.setFamilia(familia);
        }
        if(voluntario != null){
            nota.setVoluntario(voluntario);
        }

        notaRepository.save(nota);
        return NotaMapperManual.notaToDto(nota);
    }

    @Transactional
    public void deleteNota(Long id) {
        NotaEntity nota = notaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Nota " + id + " no encontrada"));
        notaRepository.deleteById(nota.getId());
    }
}