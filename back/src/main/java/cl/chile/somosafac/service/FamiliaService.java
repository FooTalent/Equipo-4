package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.mapper.FamiliaMapper;
import cl.chile.somosafac.repository.FamiliaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamiliaService {

    private final FamiliaRepository familiaRepository;
    private final FamiliaMapper familiaMapper;

    public FamiliaService(FamiliaRepository familiaRepository, FamiliaMapper familiaMapper) {
        this.familiaRepository = familiaRepository;
        this.familiaMapper = familiaMapper;
    }

    @Transactional(readOnly = true)
    public List<FamiliaDTO> getFamilia() {
        List<FamiliaEntity> familias = familiaRepository.findAll();
        return familias.stream()
                .map(familiaMapper::familiatoDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FamiliaDTO getFamilia(Long id) {
        FamiliaEntity familia = familiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familia no encontrada"));
        return familiaMapper.familiatoDto(familia);
    }

    @Transactional
    public FamiliaEntity createFamilia(FamiliaDTO familiaDTO) {
        FamiliaEntity familia = familiaMapper.familiatoEntity(familiaDTO);
        return familiaRepository.save(familia);
    }

    @Transactional
    public FamiliaDTO updateFamilia(Long id, FamiliaDTO familiaDTO) {
        FamiliaEntity familiaExistente = familiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Familia no encontrada"));

        familiaMapper.updateFamiliaFromDto(familiaDTO, familiaExistente);
        FamiliaEntity familiaActualizada = familiaRepository.save(familiaExistente);

        return familiaMapper.familiatoDto(familiaActualizada);
    }

    @Transactional
    public void deleteFamilia(Long id) {
        if (!familiaRepository.existsById(id)) {
            throw new RuntimeException("Familia no encontrada");
        }
        familiaRepository.deleteById(id);
    }
}
