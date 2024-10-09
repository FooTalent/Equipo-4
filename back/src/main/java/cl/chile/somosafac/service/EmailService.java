package cl.chile.somosafac.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
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

}
