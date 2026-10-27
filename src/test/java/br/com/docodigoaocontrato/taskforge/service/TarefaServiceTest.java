package br.com.docodigoaocontrato.taskforge.service;

import br.com.docodigoaocontrato.taskforge.dto.TarefaDTO;
import br.com.docodigoaocontrato.taskforge.model.Tarefa;
import br.com.docodigoaocontrato.taskforge.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @Test
    void deveCadastrarTarefa() {
        // DADO que o repositório vai salvar a tarefa
        TarefaDTO dto = new TarefaDTO(null, "Estudar", 3, false);
        Tarefa tarefaSalva = new Tarefa("Estudar", 3);
        tarefaSalva.setId(1L);

        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefaSalva);

        // QUANDO eu chamo o service para cadastrar
        TarefaDTO resultado = tarefaService.cadastrar(dto);

        // ENTÃO a tarefa retornada tem os dados corretos
        assertEquals(1L, resultado.getId());
        assertEquals("Estudar", resultado.getNome());
        assertEquals(3, resultado.getPrioridade());

        // E o repositório foi chamado uma vez
        verify(tarefaRepository).save(any(Tarefa.class));
    }

    @Test
    void deveListarTarefas() {
        // DADO que o repositório tem duas tarefas
        Tarefa t1 = new Tarefa("Estudar", 3);
        t1.setId(1L);
        Tarefa t2 = new Tarefa("Praticar", 5);
        t2.setId(2L);

        when(tarefaRepository.findAll()).thenReturn(List.of(t1, t2));

        // QUANDO eu chamo o service para listar
        List<TarefaDTO> resultado = tarefaService.listar();

        // ENTÃO retorna as duas tarefas
        assertEquals(2, resultado.size());
        assertEquals("Estudar", resultado.get(0).getNome());
        assertEquals("Praticar", resultado.get(1).getNome());

        verify(tarefaRepository).findAll();
    }

    @Test
    void deveBuscarTarefaPorIdQuandoExistir() {
        // DADO que existe uma tarefa com id 1
        Tarefa tarefa = new Tarefa("Estudar", 3);
        tarefa.setId(1L);

        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        // QUANDO eu chamo o service
        Optional<TarefaDTO> resultado = tarefaService.buscarPorId(1L);

        // ENTÃO retorna a tarefa
        assertTrue(resultado.isPresent());
        assertEquals("Estudar", resultado.get().getNome());
    }

    @Test
    void deveDevolverVazioQuandoTarefaNaoExistir() {
        // DADO que não existe tarefa com id 999
        when(tarefaRepository.findById(999L)).thenReturn(Optional.empty());

        // QUANDO eu chamo o service
        Optional<TarefaDTO> resultado = tarefaService.buscarPorId(999L);

        // ENTÃO retorna vazio
        assertFalse(resultado.isPresent());
    }

    @Test
    void deveDeletarTarefaQuandoExistir() {
        // DADO que existe uma tarefa com id 1
        Tarefa tarefa = new Tarefa("Estudar", 3);
        tarefa.setId(1L);

        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        // QUANDO eu chamo o service
        boolean resultado = tarefaService.deletar(1L);

        // ENTÃO retorna true e o repositório é chamado
        assertTrue(resultado);
        verify(tarefaRepository).delete(tarefa);
    }
}