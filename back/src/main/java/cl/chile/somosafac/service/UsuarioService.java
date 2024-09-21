package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.mapper.UsuarioMapper;
import cl.chile.somosafac.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> obtenerTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        System.out.println("Datos recuperados: ");
        usuarios.forEach(usuario -> System.out.println("Entidad: " + usuario.getId() + ", " + usuario.getCorreo()));

        return usuarios.stream()
                .map(usuario -> {
                    UsuarioDTO usuarioDTO = usuarioMapper.usuarioToUsuarioDTO(usuario);
                    System.out.println("DTO: " + usuarioDTO.getId() + ", " + usuarioDTO.getCorreo());
                    return usuarioDTO;
                })
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public UsuarioDTO obtenerPorId(Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        return usuario.map(usuarioMapper::usuarioToUsuarioDTO).orElse(null);
    }

    @Transactional
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO);
        UsuarioEntity nuevoUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.usuarioToUsuarioDTO(nuevoUsuario);
    }

    @Transactional
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            UsuarioEntity usuario = usuarioExistente.get();
            usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO); // Actualiza el objeto usuario
            UsuarioEntity usuarioActualizado = usuarioRepository.save(usuario);
            return usuarioMapper.usuarioToUsuarioDTO(usuarioActualizado);
        }
        return null; // Manejar el caso donde no se encuentra el usuario
    }

    @Transactional
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}



