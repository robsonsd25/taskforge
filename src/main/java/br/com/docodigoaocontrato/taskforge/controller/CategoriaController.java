package br.com.docodigoaocontrato.taskforge.controller;

import br.com.docodigoaocontrato.taskforge.dto.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaDTO> listar() {
        return categoriaService.listarTodos();
    }

    @PostMapping
    public CategoriaDTO criar(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.criar(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO atualizar(
            @PathVariable Long id,
            @RequestBody CategoriaDTO categoriaDTO) {

        return categoriaService.atualizar(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {

        categoriaService.deletar(id);

        return ResponseEntity.ok().build();
    }
}