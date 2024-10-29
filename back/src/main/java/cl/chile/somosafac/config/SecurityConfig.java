package cl.chile.somosafac.config;

import cl.chile.somosafac.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/usuarios/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/familias/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/email/mensaje-registro").hasAuthority("ADMIN")
                                .requestMatchers("/api/email/general").hasAuthority("ADMIN")
                                .requestMatchers("/api/mentorias/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/voluntarios/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/contactos/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/notas/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/notificaciones/**").hasAuthority("ADMIN")
                                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
