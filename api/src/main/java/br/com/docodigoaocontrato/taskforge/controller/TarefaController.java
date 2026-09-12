package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TarefaController {

    @GetMapping("/tarefas")
    public TarefaDTO Listar() {
        return new TarefaDTO(1, "Estudar Java", 5, false);
    }
}
