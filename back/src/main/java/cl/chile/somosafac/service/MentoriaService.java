package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import cl.chile.somosafac.mapper.MentoriaMapper;
import cl.chile.somosafac.repository.MentoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MentoriaService {

    private  MentoriaRepository mentoriaRepository;
    private  MentoriaMapper mentoriaMapper;

    @Transactional(readOnly = true)
    public List<MentoriaDTO> getAllMentorias() {
        List<MentoriaEntity> mentorias = mentoriaRepository.findAll();
        return mentorias.stream()
                .map(mentoriaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MentoriaDTO getMentoria(Long id) {
        MentoriaEntity mentoria = mentoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentoria no encontrada"));
        return mentoriaMapper.toDto(mentoria);
    }

    @Transactional
    public MentoriaDTO createMentoria(MentoriaDTO mentoriaDTO) {
        MentoriaEntity nuevaMentoria = mentoriaMapper.toEntity(mentoriaDTO);
        MentoriaEntity mentoriaGuardada = mentoriaRepository.save(nuevaMentoria);
        return mentoriaMapper.toDto(mentoriaGuardada);
    }

    @Transactional
    public MentoriaDTO updateMentoria(Long id, MentoriaDTO mentoriaDTO) {
        MentoriaEntity mentoriaExistente = mentoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mentoria no encontrada"));

        mentoriaMapper.updateMentoriaFromDto(mentoriaDTO, mentoriaExistente);
        MentoriaEntity mentoriaActualizada = mentoriaRepository.save(mentoriaExistente);

        return mentoriaMapper.toDto(mentoriaActualizada);
    }

    @Transactional
    public void deleteMentoria(Long id) {
        if (!mentoriaRepository.existsById(id)) {
            throw new RuntimeException("Mentoria no encontrada");
        }
        mentoriaRepository.deleteById(id);
    }
}
