package cl.chile.somosafac.config;

import cl.chile.somosafac.entity.*;
import cl.chile.somosafac.repository.*;
import cl.chile.somosafac.security.Role;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class DataInitializer {
    //TODO Agregar campos faltantes para familia para antes del 11/14/2024 by israel RECORDATORIO
    private final FamiliaRepository familiaRepository;
    private final UsuarioRepository usuarioRepository;
    private final VoluntarioRepository voluntarioRepository;
    private final NotificacionRepository notificacionRepository;
    private final MentoriaRepository mentoriaRepository;
    private final NotaRepository notaRepository;
    private final ContactoRepository contactoRepository;

    public DataInitializer(FamiliaRepository familiaRepository,
                           UsuarioRepository usuarioRepository,
                           VoluntarioRepository voluntarioRepository,
                           NotificacionRepository notificacionRepository,
                           MentoriaRepository mentoriaRepository,
                           NotaRepository notaRepository,
                           ContactoRepository contactoRepository) {
        this.familiaRepository = familiaRepository;
        this.usuarioRepository = usuarioRepository;
        this.voluntarioRepository = voluntarioRepository;
        this.notificacionRepository = notificacionRepository;
        this.mentoriaRepository = mentoriaRepository;
        this.notaRepository = notaRepository;
        this.contactoRepository = contactoRepository;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            Faker faker = new Faker();

            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setNombre(faker.name().firstName());
            usuario.setApellido(faker.name().lastName());
            usuario.setCorreo(faker.internet().emailAddress());
            usuario.setContrasenaHash("hashed_password");
            usuario.setTipoUsuario(Role.ADMIN);
            usuario.setFechaRegistro(LocalDateTime.now());
            usuario.setActivo(true);
            usuario.setVerificado(false);
            usuario.setAceptarTerminos(true);
            usuarioRepository.save(usuario);

            // Crear usuarios de prueba
            for (int i = 0; i < 5; i++) {
                usuario = new UsuarioEntity();
                usuario.setNombre(faker.name().firstName());
                usuario.setApellido(faker.name().lastName());
                usuario.setCorreo(faker.internet().emailAddress());
                usuario.setContrasenaHash("hashed_password");
                usuario.setTipoUsuario(Role.FAMILIA);
                usuario.setFechaRegistro(LocalDateTime.now());
                usuario.setActivo(true);
                usuario.setVerificado(false);
                usuario.setAceptarTerminos(true);
                usuarioRepository.save(usuario);

                // Crear familias asociadas al usuario
                FamiliaEntity familia = new FamiliaEntity();
                familia.setUsuario(usuario);
                familia.setNombreFaUno(faker.name().fullName());
                familia.setRutFaUno(faker.number().digits(8) + "-" + faker.number().numberBetween(0, 9));
                familia.setFechaNacimientoFaUno(LocalDate.now().minusYears(faker.number().numberBetween(18, 60)));
                familia.setNombreFaDos(faker.name().fullName());
                familia.setRutFaDos(faker.number().digits(8) + "-" + faker.number().numberBetween(0, 9));
                familia.setFechaNacimientoFaDos(LocalDate.now().minusYears(faker.number().numberBetween(18, 60)));
                familia.setEstadoCivil("Casado");
                familia.setTelefono(faker.phoneNumber().cellPhone());
                familia.setEmail(faker.internet().emailAddress());
                familia.setRegion("Región Metropolitana");
                familia.setComuna("Santiago");
                familia.setDireccion(faker.address().streetAddress());
                familia.setProgramaFundacionActual("Programa A");
                familia.setIngresoFa(LocalDate.now());
                familiaRepository.save(familia);

                // Crear voluntario
                VoluntarioEntity voluntario = new VoluntarioEntity();
                voluntario.setUsuario(usuario);
                voluntario.setOcupacion("Trabajador social");
                voluntario.setEstadoVoluntario("Activo");
                voluntarioRepository.save(voluntario);

                // Crear notificación
                NotificacionEntity notificacion = new NotificacionEntity();
                notificacion.setUsuario(usuario);
                notificacion.setMensaje("Bienvenido a la plataforma");
                notificacion.setFechaEnvio(LocalDateTime.now());
                notificacion.setTipoNotificacion("General");
                notificacion.setVisto(false);
                notificacionRepository.save(notificacion);
            }
            // Crear mentorías de prueba
            for (int i = 0; i < 3; i++) {
                MentoriaEntity mentoria = new MentoriaEntity();
                mentoria.setFamiliaMentora(familiaRepository.findById(3L).orElse(null)); // Cambia esto según sea necesario
                mentoria.setFamiliaMentorada(familiaRepository.findById(4L).orElse(null)); // Cambia esto según sea necesario
                mentoria.setFechaAsignacion(LocalDateTime.now().minusDays(faker.number().numberBetween(1, 30)));
                mentoria.setEstadoMentoria(faker.options().option("Pendiente", "En Proceso", "Completada"));
                mentoriaRepository.save(mentoria);
            }

            // Crear contactos de prueba
            for (int i = 0; i < 5; i++) {
                ContactoEntity contacto = new ContactoEntity();
                contacto.setFamilia(familiaRepository.findById((long) (i + 3)).orElse(null)); // Asigna una familia al azar
                contacto.setUsuario(usuarioRepository.findById((long) (i + 2)).orElse(null)); // Asigna un usuario al azar
                contacto.setFechaContacto(LocalDateTime.now().minusDays(faker.number().numberBetween(1, 60)));
                contacto.setDescripcionContacto(faker.lorem().sentence(20));
                contactoRepository.save(contacto);
            }

            // Crear notas de prueba
            for (int i = 0; i < 5; i++) {
                NotaEntity nota = new NotaEntity();
                nota.setFamilia(familiaRepository.findById((long) (i + 4)).orElse(null)); // Asigna una familia al azar
                nota.setVoluntario(voluntarioRepository.findById((long) (i + 3)).orElse(null)); // Asigna un voluntario al azar
                nota.setDescripcion(faker.lorem().paragraph(3));
                nota.setFechaCreacion(LocalDateTime.now().minusDays(faker.number().numberBetween(1, 100)));
                notaRepository.save(nota);
            }

            System.out.println("Datos de prueba generados correctamente.");
        };

    }
}


