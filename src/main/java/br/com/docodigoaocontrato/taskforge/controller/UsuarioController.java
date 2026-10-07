package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.UsuarioCadastroDTO;
import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioCadastroDTO dto) {

        Optional<UsuarioDTO> criado = usuarioService.cadastrar(dto);

        if (criado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(criado.get());
    }

    @PutMapping("/{id}/desativar")
    public ResponseEntity<UsuarioDTO> desativar(@PathVariable Long id) {

        Optional<UsuarioDTO> desativado = usuarioService.desativar(id);

        if (desativado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(desativado.get());
    }
}