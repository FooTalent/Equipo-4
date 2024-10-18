package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.mapper.FamiliaMapperManual;
import cl.chile.somosafac.repository.FamiliaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FamiliaService {

    private final FamiliaRepository familiaRepository;

    public FamiliaService(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    @Transactional(readOnly = true)
    public List<FamiliaDTO> getFamilias() {
        List<FamiliaEntity> familias = familiaRepository.findAll();
        return familias.stream()
                .map(FamiliaMapperManual::familiaToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FamiliaDTO getFamilia(Long id) {
        Optional<FamiliaEntity> familia = familiaRepository.findById(id);
        return familia.map(FamiliaMapperManual::familiaToDto).orElse(null);
    }

    @Transactional
    public FamiliaDTO createFamilia(FamiliaDTO familiaDTO) {
        FamiliaEntity familia = FamiliaMapperManual.familiaToEntity(familiaDTO);
        FamiliaEntity nuevaFamilia = familiaRepository.save(familia);
        return FamiliaMapperManual.familiaToDto(nuevaFamilia);
    }

    @Transactional
    public Optional<FamiliaDTO> updateFamilia(Long id, FamiliaDTO familiaDTO) {
        System.out.println("updateFamilia - id: " + id);
        Optional<FamiliaEntity> familiaExistente = familiaRepository.findById(id);
        System.out.println("familiaExistente: " + familiaExistente.isPresent());

        return familiaExistente.map(familia -> {
            System.out.println("familia: " + familia);
            FamiliaMapperManual.updateFamiliaFromDto(familiaDTO, familia);
            FamiliaEntity familiaActualizada = familiaRepository.save(familia);
            System.out.println("familiaActualizada: " + familiaActualizada);
            return FamiliaMapperManual.familiaToDto(familiaActualizada);
        });
    }

    @Transactional(readOnly = true)
    public List<FamiliaDTO> searchFamilias(String nombre) {
        List<FamiliaEntity> familias = familiaRepository.findByNombreFaUnoContainingIgnoreCase(nombre);
        return familias.stream()
                .map(FamiliaMapperManual::familiaToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteFamilia(Long id) {
        Optional<FamiliaEntity> familiaExistente = familiaRepository.findById(id);
        if (familiaExistente.isPresent()) {
            familiaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Familia no encontrada");

        }
    }
}
