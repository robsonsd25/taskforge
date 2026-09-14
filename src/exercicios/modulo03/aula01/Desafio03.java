package src.exercicios.modulo03.aula01;

import src.*;

import java.util.ArrayList;
import java.util.List;

public class Desafio03 {

    public static void main(String[] args) {


        List<Tarefa> listaTarefa = new ArrayList<>();

        TarefaSimples t1 = new TarefaSimples("Estudar Java", "Ver aula de listas", 5, "Você", 2.0, TarefaStatus.EM_ANDAMENTO);
        TarefaComPrazo t2 = new TarefaComPrazo("Projeto", "Enviar para o cliente", 4, "Dev", 5.0, TarefaStatus.PENDENTE, 24.0);
        TarefaSimples t3 = new TarefaSimples("Lavar louça", "Organizar a cozinha", 1, "Casa", 0.5, TarefaStatus.CONCLUIDA);
        TarefaComPrazo t4 = new TarefaComPrazo("Reunião", "Alinhamento semanal", 3, "Equipe", 1.0, TarefaStatus.PENDENTE, 2.0);

        listaTarefa.add(t1);
        listaTarefa.add(t2);
        listaTarefa.add(t3);
        listaTarefa.add(t4);


        System.out.println("=== 2. CONTAR E LISTAR ===");
        System.out.println("Total de tarefas na lista: " + listaTarefa.size());

        for (Tarefa t : listaTarefa) {
            t.resumo();
        }


        System.out.println("\n=== 3. ESPIAR ===");
        Tarefa primeira = listaTarefa.get(0);
        Tarefa ultima = listaTarefa.get(listaTarefa.size() - 1);

        System.out.println("Primeira tarefa: " + primeira.getNome());
        System.out.println("Última tarefa: " + ultima.getNome());


        System.out.println("\n=== 4. REMOVER DE DOIS JEITOS ===");

        listaTarefa.remove(0);
        System.out.println("Após remover pelo índice 0, tamanho: " + listaTarefa.size());


        listaTarefa.remove(t4);
        System.out.println("Após remover o objeto t4, tamanho: " + listaTarefa.size());


        System.out.println("\n=== 5. RECEBER UM LOTE ===");
        List<Tarefa> backlog = new ArrayList<>();

        backlog.add(new TarefaSimples("Tarefa Nova 1", "Backlog A", 2, "Suporte", 1.0, TarefaStatus.PENDENTE));
        backlog.add(new TarefaSimples("Tarefa Nova 2", "Backlog B", 3, "Suporte", 3.5, TarefaStatus.CONCLUIDA));

        listaTarefa.addAll(backlog);
        System.out.println("Total após despejar o backlog: " + listaTarefa.size());


        System.out.println("\n=== 6. FAXINA EM LOTE ===");
        List<Tarefa> concluidas = new ArrayList<>();

        for (Tarefa t : listaTarefa) {
            if (t.getStatus() == TarefaStatus.CONCLUIDA) {
                concluidas.add(t);
            }
        }

        listaTarefa.removeAll(concluidas);
        System.out.println("Quantas tarefas sobraram após a faxina: " + listaTarefa.size());


        System.out.println("\n=== 7. PLACAR FINAL ===");
        int qtdPendentes = 0;
        int qtdEmAndamento = 0;
        int qtdConcluidas = 0;
        int qtdCanceladas = 0;

        for (Tarefa t : listaTarefa) {
            switch (t.getStatus()) {
                case PENDENTE:
                    qtdPendentes++;
                    break;
                case EM_ANDAMENTO:
                    qtdEmAndamento++;
                    break;
                case CONCLUIDA:
                    qtdConcluidas++;
                    break;
                case CANCELADA:
                    qtdCanceladas++;
                    break;
            }
        }

        System.out.println("Pendentes: " + qtdPendentes);
        System.out.println("Em Andamento: " + qtdEmAndamento);
        System.out.println("Concluídas: " + qtdConcluidas);
        System.out.println("Canceladas: " + qtdCanceladas);
    }
}
