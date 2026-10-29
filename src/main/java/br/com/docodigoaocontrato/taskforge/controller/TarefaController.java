package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<TarefaDTO> listar() {
        return tarefaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscar(@PathVariable Long id) {
        Optional<TarefaDTO> dto = tarefaService.buscarPorId(id);

        if (dto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaDTO cadastrar(@Valid @RequestBody TarefaDTO dto) {
        return tarefaService.cadastrar(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizar(@PathVariable Long id,
                                               @Valid @RequestBody TarefaDTO dto) {
        Optional<TarefaDTO> atualizada = tarefaService.atualizar(id, dto);

        if (atualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(atualizada.get());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
    }
}