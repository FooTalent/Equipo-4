package cl.chile.somosafac.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
}
