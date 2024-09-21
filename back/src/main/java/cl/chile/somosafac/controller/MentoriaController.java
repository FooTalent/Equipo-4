package cl.chile.somosafac.controller;

import cl.chile.somosafac.DTO.MentoriaDTO;
import cl.chile.somosafac.service.MentoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentorias")
public class MentoriaController {


    private final MentoriaService mentoriaService;

    public MentoriaController(MentoriaService mentoriaService) {
        this.mentoriaService = mentoriaService;
    }

    @GetMapping
    public ResponseEntity<List<MentoriaDTO>> obtenerTodasLasMentorias() {
        List<MentoriaDTO> mentorias = mentoriaService.getAllMentorias();
        return ResponseEntity.ok(mentorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentoriaDTO> obtenerMentoriaPorId(@PathVariable Long id) {
        MentoriaDTO mentoriaDTO = mentoriaService.getMentoria(id);
        return ResponseEntity.ok(mentoriaDTO);
    }

    @PostMapping
    public ResponseEntity<MentoriaDTO> guardarMentoria(@RequestBody MentoriaDTO mentoriaDTO) {
        MentoriaDTO nuevaMentoria = mentoriaService.createMentoria(mentoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMentoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentoriaDTO> actualizarMentoria(@PathVariable Long id, @RequestBody MentoriaDTO mentoriaDTO) {
        MentoriaDTO mentoriaActualizada = mentoriaService.updateMentoria(id, mentoriaDTO);
        return ResponseEntity.ok(mentoriaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMentoria(@PathVariable Long id) {
        mentoriaService.deleteMentoria(id);
        return ResponseEntity.noContent().build();
    }
}
