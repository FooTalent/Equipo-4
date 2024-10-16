package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.EmailDTO;
import cl.chile.somosafac.entity.FamiliaEntity;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.repository.FamiliaRepository;
import cl.chile.somosafac.repository.UsuarioRepository;
import cl.chile.somosafac.security.Role;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final UsuarioRepository usuarioRepository;
    private final FamiliaRepository familiaRepository;

    public EmailService(JavaMailSender mailSender, UsuarioRepository usuarioRepository, FamiliaRepository familiaRepository) {
        this.mailSender = mailSender;
        this.usuarioRepository = usuarioRepository;
        this.familiaRepository = familiaRepository;
    }

    public void enviarEmail(String email, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("somosafac.dev@gmail.com");
            message.setTo(email);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar email: " + e.getMessage());
        }
    }

    public void enviarEmailConPresentacion(String email, String subject, String body, String password) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("somosafac.dev@gmail.com");
            helper.setTo(email);
            helper.setSubject(subject);

            var inputStream = Objects.requireNonNull(
                    EmailService.class.getResourceAsStream("/template/email/emailBienvenida.html")
            );
            String htmlContent = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            htmlContent = htmlContent.replace("{{email}}", email)
                    .replace("{{passwordHash}}", password);

            helper.setText(htmlContent, true);

            ClassPathResource logo = new ClassPathResource("/static/images/portada.png");
            helper.addInline("portada.png", logo);

            mailSender.send(message);

        } catch (Exception e) {
            throw new RuntimeException("Error al enviar email: " + e.getMessage());
        }
    }

    public void enviarEmailDestinatarios(EmailDTO emailDTO) {
        if (emailDTO == null || emailDTO.getDestinatario() == null) {
            throw new IllegalArgumentException("El Email o el destinatario no pueden ser nulos.");
        }

        List<String> destinatarios = new ArrayList<>();

        if (emailDTO.getDestinatario().equals("Listado General")) {
            List<UsuarioEntity> usuarios = usuarioRepository.findByTipoUsuario(Role.ADMIN);
            System.out.println(usuarios);

            destinatarios = usuarios.stream()
                    .map(UsuarioEntity::getCorreo)
                    .collect(Collectors.toList());
        }

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("somosafac.dev@gmail.com");

            for (String email : destinatarios) {
                helper.addBcc(email);
            }

            message.setSubject(emailDTO.getTitulo());
            message.setText(emailDTO.getMensaje());

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar emails: " + e.getMessage());
        }
    }
}
