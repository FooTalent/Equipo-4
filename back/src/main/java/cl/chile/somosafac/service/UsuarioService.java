package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.RequestActualizarUsuarioDTO;
import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> obtenerTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(UsuarioDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO obtenerPorId(Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        return usuario.map(UsuarioDTO::fromEntity).orElse(null);
    }


    @Transactional
    public UsuarioDTO actualizarUsuario(Long id, RequestActualizarUsuarioDTO usuarioActualizados) {
        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            UsuarioEntity usuario = usuarioExistente.get();

            if (usuarioActualizados.getNombre() != null) {
                usuario.setNombre(usuarioActualizados.getNombre());
            }
            if (usuarioActualizados.getApellido() != null) {
                usuario.setApellido(usuarioActualizados.getApellido());
            }
            if (usuarioActualizados.getCorreo() != null) {
                usuario.setCorreo(usuarioActualizados.getCorreo());
            }

            usuario = usuarioRepository.save(usuario);

            return UsuarioDTO.fromEntity(usuario);
        } else {
            throw new NoSuchElementException("Usuario " + id + " no encontrado");
        }
    }


    @Transactional
    public void eliminarUsuario(Long id) {
        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            UsuarioEntity usuario = usuarioExistente.get();
            usuarioRepository.deleteById(usuario.getId());
        }else{
            throw new NoSuchElementException("Usuario " + id + " no encontrado");
        }
    }
}