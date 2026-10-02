package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.CategoriaDTO;
import br.com.docodigoaocontrato.taskforge.model.Categoria;
import br.com.docodigoaocontrato.taskforge.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> listarTodos() {

        return categoriaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public CategoriaDTO criar(CategoriaDTO categoriaDTO) {

        Categoria categoria = new Categoria();

        categoria.setNome(categoriaDTO.getNome());

        Categoria categoriaSalva = categoriaRepository.save(categoria);

        return mapToDTO(categoriaSalva);
    }

    public CategoriaDTO atualizar(Long id, CategoriaDTO categoriaDTO) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada"));

        categoria.setNome(categoriaDTO.getNome());

        Categoria categoriaAtualizada =
                categoriaRepository.save(categoria);

        return mapToDTO(categoriaAtualizada);
    }

    public void deletar(Long id) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada"));

        categoriaRepository.delete(categoria);
    }

    private CategoriaDTO mapToDTO(Categoria categoria) {

        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNome()
        );
    }
}