package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Comentario;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.model.Usuario;
import br.com.docodigoaocontrato.taskforge.repository.ComentarioRepository;
import br.com.docodigoaocontrato.taskforge.repository.TarefaRepository;
import br.com.docodigoaocontrato.taskforge.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final TarefaRepository tarefaRepository;

    public ComentarioService(
            ComentarioRepository comentarioRepository,
            UsuarioRepository usuarioRepository,
            TarefaRepository tarefaRepository) {

        this.comentarioRepository = comentarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public List<ComentarioDTO> listarTodos() {

        return comentarioRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public ComentarioDTO criar(ComentarioDTO comentarioDTO) {

        Usuario usuario = usuarioRepository
                .findById(comentarioDTO.getUsuarioId())
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        Tarefa tarefa = tarefaRepository
                .findById(comentarioDTO.getTarefaId())
                .orElseThrow(() ->
                        new RuntimeException("Tarefa não encontrada"));

        Comentario comentario = new Comentario();

        comentario.setDescricao(comentarioDTO.getDescricao());
        comentario.setUsuario(usuario);
        comentario.setTarefa(tarefa);

        Comentario comentarioSalvo =
                comentarioRepository.save(comentario);

        return mapToDTO(comentarioSalvo);
    }

    public ComentarioDTO atualizar(
            Long id,
            ComentarioDTO comentarioDTO) {

        Comentario comentario = comentarioRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Comentário não encontrado"));

        Usuario usuario = usuarioRepository
                .findById(comentarioDTO.getUsuarioId())
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        Tarefa tarefa = tarefaRepository
                .findById(comentarioDTO.getTarefaId())
                .orElseThrow(() ->
                        new RuntimeException("Tarefa não encontrada"));

        comentario.setDescricao(comentarioDTO.getDescricao());
        comentario.setUsuario(usuario);
        comentario.setTarefa(tarefa);

        Comentario comentarioAtualizado =
                comentarioRepository.save(comentario);

        return mapToDTO(comentarioAtualizado);
    }


    public boolean deletar(Long id) {

        if (!comentarioRepository.existsById(id)) {
            return false;
        }

        comentarioRepository.deleteById(id);

        return true;
    }

    private ComentarioDTO mapToDTO(Comentario comentario) {

        return new ComentarioDTO(
                comentario.getId(),
                comentario.getDescricao(),
                comentario.getUsuario().getId(),
                comentario.getTarefa().getId()
        );
    }
}