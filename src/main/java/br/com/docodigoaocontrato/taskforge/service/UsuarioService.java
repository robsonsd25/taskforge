package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import br.com.docodigoaocontrato.taskforge.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public UsuarioDTO criar(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return mapToDTO(usuarioSalvo);
    }

    public UsuarioDTO atualizar(Long id, UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return mapToDTO(usuarioAtualizado);
    }

    public void deletar(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioRepository.delete(usuario);
    }

    private UsuarioDTO mapToDTO(Usuario usuario) {

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}