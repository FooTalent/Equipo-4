package cl.chile.somosafac.controller;

import cl.chile.somosafac.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestParam String email) {
        emailService.enviarEmail(email, "Somos AFAC ✉\uFE0F", "Mensaje de prueba! \uD83D\uDE0E");
        return ResponseEntity.ok("Email enviado exitosamente!");
    }
}
