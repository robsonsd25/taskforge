package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<TarefaDTO> listar() {
        return tarefaService.listarTodos();
    }

    @PostMapping
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.criar(tarefaDTO);
    }

    @PutMapping("/{id}")
    public TarefaDTO atualizar(
            @PathVariable Long id,
            @RequestBody TarefaDTO tarefaDTO) {

        return tarefaService.atualizar(id, tarefaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {

        tarefaService.deletar(id);

        return ResponseEntity.ok().build();
    }
}