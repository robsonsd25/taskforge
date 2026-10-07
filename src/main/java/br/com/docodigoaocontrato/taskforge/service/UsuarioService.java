package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import br.com.docodigoaocontrato.taskforge.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<UsuarioDTO> cadastrar(UsuarioCadastroDTO dto) {

        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            return Optional.empty();
        }

        String senhaEmbaralhada = encoder.encode(dto.getSenha());
        Usuario usuario = new Usuario(dto.getNome(), dto.getEmail(), senhaEmbaralhada);
        Usuario salvo = usuarioRepository.save(usuario);

        return Optional.of(toDto(salvo));
    }

    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<UsuarioDTO> desativar(Long id) {

        Optional<Usuario> encontrado = usuarioRepository.findById(id);

        if (encontrado.isEmpty()) {
            return Optional.empty();
        }

        Usuario usuario = encontrado.get();
        usuario.setAtivo(false);
        Usuario salvo = usuarioRepository.save(usuario);

        return Optional.of(toDto(salvo));
    }

    private UsuarioDTO toDto(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAtivo()
        );
    }
}