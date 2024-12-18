package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.entity.MentoriaEntity;
import cl.chile.somosafac.exception.custom.ResourceNotFoundException;
import cl.chile.somosafac.mapper.MentoriaMapperManual;
import cl.chile.somosafac.repository.MentoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentoriaService {

    private final MentoriaRepository mentoriaRepository;

    public MentoriaService(MentoriaRepository mentoriaRepository) {
        this.mentoriaRepository = mentoriaRepository;
    }

    @Transactional(readOnly = true)
    public List<MentoriaDTO> getMentorias() {
        List<MentoriaEntity> mentorias = mentoriaRepository.findAll();
        if (mentorias.isEmpty()){
            throw new ResourceNotFoundException("Mentorias");
        }
        return mentorias.stream()
                .map(MentoriaMapperManual::mentoriaToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MentoriaDTO getMentoria(Long id) {
        MentoriaEntity mentoria = mentoriaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Mentoria","ID",id));

        return MentoriaMapperManual.mentoriaToDto(mentoria);
    }

    @Transactional
    public MentoriaDTO createMentoria(MentoriaDTO mentoriaDTO) {
        MentoriaEntity mentoria = MentoriaMapperManual.mentoriaToEntity(mentoriaDTO);
        MentoriaEntity nuevaMentoria = mentoriaRepository.save(mentoria);
        return MentoriaMapperManual.mentoriaToDto(nuevaMentoria);
    }

    @Transactional
    public Optional<MentoriaDTO> updateMentoria(Long id, MentoriaDTO mentoriaDTO) {
        Optional<MentoriaEntity> mentoriaExistente = mentoriaRepository.findById(id);
        if (mentoriaExistente.isEmpty()){
            throw new ResourceNotFoundException("Mentoria","ID",id);
        }
        return mentoriaExistente.map(mentoria -> {
            MentoriaMapperManual.updateMentoriaFromDto(mentoriaDTO, mentoria);
            MentoriaEntity mentoriaActualizada = mentoriaRepository.save(mentoria);
            return MentoriaMapperManual.mentoriaToDto(mentoriaActualizada);
        });
    }

    @Transactional
    public void deleteMentoria(Long id) {
        Optional<MentoriaEntity> mentoriaExistente = mentoriaRepository.findById(id);
        if (mentoriaExistente.isPresent()) {
            mentoriaRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Mentoria","ID",id);
        }
    }
}