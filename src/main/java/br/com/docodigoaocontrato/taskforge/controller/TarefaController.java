package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/tarefas")
    public List<TarefaDTO> listar() {
        return tarefaService.buscarTodos();
    }

    @GetMapping("/tarefas/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        TarefaDTO tarefaDTO = tarefaService.buscarPorId(id);
        if (tarefaDTO != null) {
            return ResponseEntity.ok(tarefaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tarefas")
    public ResponseEntity<TarefaDTO> criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        TarefaDTO tarefaCriada = tarefaService.criarTarefa(tarefaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        Optional<TarefaDTO> tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefaDTO);
        if (tarefaAtualizada.isPresent()) {
            return ResponseEntity.ok(tarefaAtualizada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        boolean deletado = tarefaService.deleteTarefa(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tarefas/prioridade")
        public ResponseEntity<List<TarefaDTO>> buscarTarefasPorPrioridade(@RequestParam String prioridade) {
        List<TarefaDTO> tarefas = Collections.singletonList(tarefaService.buscarPorId(prioridade));
        return ResponseEntity.ok(tarefas);
    }

}


