package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.UsuarioDTO;
import br.com.docodigoaocontrato.taskforge.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.listarTodos();
    }

    @PostMapping
    public UsuarioDTO criar(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.criar(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizar(
            @PathVariable Long id,
            @RequestBody UsuarioDTO usuarioDTO) {

        return usuarioService.atualizar(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {

        usuarioService.deletar(id);

        return ResponseEntity.ok().build();
    }
}