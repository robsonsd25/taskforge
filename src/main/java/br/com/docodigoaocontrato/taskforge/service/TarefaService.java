package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaDTO> listar() {
        return tarefaRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public Optional<TarefaDTO> buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .map(this::toDto);
    }

    public TarefaDTO cadastrar(TarefaDTO dto) {

        Tarefa tarefa = new Tarefa(dto.getNome(), dto.getPrioridade());

        if (dto.getConcluida() != null) {
            tarefa.setConcluida(dto.getConcluida());
        }

        Tarefa salva = tarefaRepository.save(tarefa);

        return toDto(salva);
    }

    public Optional<TarefaDTO> atualizar(Long id, TarefaDTO dto) {

        Optional<Tarefa> encontrada = tarefaRepository.findById(id);

        if (encontrada.isEmpty()) {
            return Optional.empty();
        }

        Tarefa tarefa = encontrada.get();
        tarefa.setNome(dto.getNome());
        tarefa.setPrioridade(dto.getPrioridade());
        tarefa.setConcluida(dto.getConcluida());

        Tarefa salva = tarefaRepository.save(tarefa);

        return Optional.of(toDto(salva));
    }

    public boolean deletar(Long id) {

        Optional<Tarefa> encontrada = tarefaRepository.findById(id);

        if (encontrada.isEmpty()) {
            return false;
        }

        tarefaRepository.delete(encontrada.get());
        return true;
    }

    private TarefaDTO toDto(Tarefa tarefa) {
        return new TarefaDTO(
                tarefa.getId(),
                tarefa.getNome(),
                tarefa.getPrioridade(),
                tarefa.getConcluida()
        );
    }
}