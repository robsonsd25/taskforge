package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.service.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public List<ComentarioDTO> listar() {
        return comentarioService.listarTodos();
    }

    @PostMapping
    public ComentarioDTO criar(@RequestBody ComentarioDTO comentarioDTO) {
        return comentarioService.criar(comentarioDTO);
    }

    @PutMapping("/{id}")
    public ComentarioDTO atualizar(
            @PathVariable Long id,
            @RequestBody ComentarioDTO comentarioDTO) {

        return comentarioService.atualizar(id, comentarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!comentarioService.deletar(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}