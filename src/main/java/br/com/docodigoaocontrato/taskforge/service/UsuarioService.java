package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.LoginDTO;
import br.com.docodigoaocontrato.taskforge.dto.LoginRespostaDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import br.com.docodigoaocontrato.taskforge.repository.UsuarioRepository;
import br.com.docodigoaocontrato.taskforge.security.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final JwtService jwtService = new JwtService();

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

    public Optional<LoginRespostaDTO> login(LoginDTO dto) {

        Optional<Usuario> encontrado = usuarioRepository.findByEmail(dto.getEmail());

        if (encontrado.isEmpty()) {
            return Optional.empty();
        }

        Usuario usuario = encontrado.get();

        if (!encoder.matches(dto.getSenha(), usuario.getSenha())) {
            return Optional.empty();
        }

        String token = jwtService.gerarToken(usuario.getEmail(), usuario.getNome());

        return Optional.of(new LoginRespostaDTO(token, usuario.getNome()));
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