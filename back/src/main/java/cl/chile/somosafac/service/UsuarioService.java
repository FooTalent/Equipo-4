package cl.chile.somosafac.service;

import cl.chile.somosafac.DTO.UsuarioDTO;
import cl.chile.somosafac.entity.UsuarioEntity;
import cl.chile.somosafac.exception.ResourceNotFoundException;
import cl.chile.somosafac.mapper.UsuarioMapper;
import cl.chile.somosafac.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
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
        if (usuarios.isEmpty()){
            throw new ResourceNotFoundException("Usuarios");
        }
        return usuarios.stream()
                .map(UsuarioDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO obtenerPorId(Long id) {
        Optional<UsuarioEntity> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new ResourceNotFoundException("Usuario","ID",id);
        }
        return usuario.map(UsuarioDTO::fromEntity).orElse(null);
    }


    @Transactional
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            UsuarioEntity usuario = usuarioExistente.get();
            usuario.setCorreo(usuarioDTO.getCorreo());
    //      usuario.setContrasenaHash(usuarioDTO.getContrasenaHash());
            usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());
            usuario.setActivo(usuarioDTO.getActivo());
            usuario.setVerificado(usuarioDTO.getVerificado());
            usuario.setAceptarTerminos(usuarioDTO.getAceptarTerminos());

            usuario = usuarioRepository.save(usuario);

            return UsuarioDTO.fromEntity(usuario);
        }else {
            throw new ResourceNotFoundException("Usuario","ID",id);
        }



    }


    @Transactional
    public void eliminarUsuario(Long id) {
        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            UsuarioEntity usuario = usuarioExistente.get();
            usuarioRepository.deleteById(usuario.getId());
        }else{
            throw new ResourceNotFoundException("Usuario","ID",id);
        }
    }
}