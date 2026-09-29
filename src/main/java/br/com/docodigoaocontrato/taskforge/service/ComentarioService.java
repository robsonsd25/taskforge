package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.ComentarioDTO;
import br.com.docodigoaocontrato.taskforge.model.Comentario;
import br.com.docodigoaocontrato.taskforge.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public List<ComentarioDTO> listarTodos() {
        return comentarioRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    private ComentarioDTO mapToDTO(Comentario comentario) {
        return new ComentarioDTO(comentario.getDescricao(), comentario.getId(),
                comentario.getAutor());

    }
}
