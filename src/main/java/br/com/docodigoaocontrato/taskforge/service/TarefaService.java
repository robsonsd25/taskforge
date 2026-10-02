package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Categoria;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import br.com.docodigoaocontrato.taskforge.repository.CategoriaRepository;
import br.com.docodigoaocontrato.taskforge.repository.TarefaRepository;
import br.com.docodigoaocontrato.taskforge.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final CategoriaRepository categoriaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(
            TarefaRepository tarefaRepository,
            CategoriaRepository categoriaRepository,
            UsuarioRepository usuarioRepository) {

        this.tarefaRepository = tarefaRepository;
        this.categoriaRepository = categoriaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<TarefaDTO> listarTodos() {
        return tarefaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public TarefaDTO criar(TarefaDTO tarefaDTO) {

        Categoria categoria = categoriaRepository.findById(tarefaDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Usuario usuario = usuarioRepository.findById(tarefaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Tarefa tarefa = new Tarefa();

        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setCategoria(categoria);
        tarefa.setUsuario(usuario);

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        return mapToDTO(tarefaSalva);
    }

    public TarefaDTO atualizar(Long id, TarefaDTO tarefaDTO) {

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        Categoria categoria = categoriaRepository.findById(tarefaDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Usuario usuario = usuarioRepository.findById(tarefaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setCategoria(categoria);
        tarefa.setUsuario(usuario);

        Tarefa tarefaAtualizada = tarefaRepository.save(tarefa);

        return mapToDTO(tarefaAtualizada);
    }

    public void deletar(Long id) {

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefaRepository.delete(tarefa);
    }

    private TarefaDTO mapToDTO(Tarefa tarefa) {

        return new TarefaDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getCategoria().getId(),
                tarefa.getUsuario().getId()
        );
    }
}