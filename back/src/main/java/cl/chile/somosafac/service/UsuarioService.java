package cl.chile.somosafac.service;
import cl.chile.somosafac.DTO.UsuarioDTO;

import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.mapper.UsuarioMapper;
import cl.chile.somosafac.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private  UsuarioRepository usuarioRepository;
    private  UsuarioMapper usuarioMapper;

    @Transactional(readOnly = true)
    public List<UsuarioDTO> obtenerTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::usuarioToUsuarioDTO)
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
            usuarioMapper.usuarioDTOToUsuario(usuarioDTO);
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



