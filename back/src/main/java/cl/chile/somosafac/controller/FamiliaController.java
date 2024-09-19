package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.FamiliaDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.service.FamiliaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familias")
@RequiredArgsConstructor
public class FamiliaController {

    private  FamiliaService familiaService;

    @GetMapping
    public ResponseEntity<List<FamiliaDTO>> obtenerTodos() {
        List<FamiliaDTO> familias = familiaService.getFamilia();
        return ResponseEntity.ok(familias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliaDTO> obtenerPorId(@PathVariable Long id) {
        FamiliaDTO familia = familiaService.getFamilia(id);
        return familia != null ? ResponseEntity.ok(familia) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<FamiliaEntity> crearFamilia(@RequestBody FamiliaDTO familiaDTO) {
        FamiliaEntity nuevaFamilia = familiaService.createFamilia(familiaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFamilia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliaDTO> actualizarFamilia(@PathVariable Long id, @RequestBody FamiliaDTO familiaDTO) {
        FamiliaDTO familiaActualizada = familiaService.updateFamilia(id, familiaDTO);
        return familiaActualizada != null ? ResponseEntity.ok(familiaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFamilia(@PathVariable Long id) {
        familiaService.deleteFamilia(id);
        return ResponseEntity.noContent().build();
    }
}
