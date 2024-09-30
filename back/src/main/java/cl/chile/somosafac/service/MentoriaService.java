package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import cl.chile.somosafac.mapper.MentoriaMapper;
import cl.chile.somosafac.repository.MentoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentoriaService {

    private final MentoriaRepository mentoriaRepository;
    private final MentoriaMapper mentoriaMapper;

    public MentoriaService(MentoriaRepository mentoriaRepository, MentoriaMapper mentoriaMapper) {
        this.mentoriaRepository = mentoriaRepository;
        this.mentoriaMapper = mentoriaMapper;
    }

    @Transactional(readOnly = true)
    public List<MentoriaDTO> getMentorias() {
        List<MentoriaEntity> mentorias = mentoriaRepository.findAll();
        return mentorias.stream()
                .map(mentoriaMapper::mentoriaToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MentoriaDTO getMentoria(Long id) {
        Optional<MentoriaEntity> mentoria = mentoriaRepository.findById(id);
        return mentoria.map(mentoriaMapper::mentoriaToDto).orElse(null);
    }

    @Transactional
    public MentoriaDTO createMentoria(MentoriaDTO mentoriaDTO) {
        MentoriaEntity mentoria = mentoriaMapper.mentoriaToEntity(mentoriaDTO);
        MentoriaEntity nuevaMentoria = mentoriaRepository.save(mentoria);
        return mentoriaMapper.mentoriaToDto(nuevaMentoria);
    }

    @Transactional
    public MentoriaDTO updateMentoria(Long id, MentoriaDTO mentoriaDTO) {
        Optional<MentoriaEntity> mentoriaExistente = mentoriaRepository.findById(id);
        if (mentoriaExistente.isPresent()) {
            MentoriaEntity mentoria = mentoriaExistente.get();
            mentoriaMapper.updateMentoriaFromDto(mentoriaDTO, mentoria);
            MentoriaEntity mentoriaActualizada = mentoriaRepository.save(mentoria);
            return mentoriaMapper.mentoriaToDto(mentoriaActualizada);
        }
        return null;
    }

    @Transactional
    public void deleteMentoria(Long id) {
        mentoriaRepository.deleteById(id);
    }
}