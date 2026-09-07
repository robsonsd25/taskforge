package src.exercicios.modulo02.aula02;

import src.*;

public class TestePolimorfismo {

    public static void main(String[] args) {
        Tarefa[] listaDeTarefas = new Tarefa[3];


        listaDeTarefas[0] = new TarefaSimples("Estudar Teoria", "Ler apostila de Java", 4,
                "Você", 1.5, TarefaStatus.PENDENTE);

        listaDeTarefas[1] = new TarefaComPrazo("Entregar Projeto", "Subir no GitHub", 5,
                "Dev", 4.0, TarefaStatus.EM_ANDAMENTO, 48.0);

        listaDeTarefas[2] = new TarefaRecorrente("Academia", "Treino de pernas", 2, "Atleta", 1.0, TarefaStatus.PENDENTE, 3);


        System.out.println("=== EXIBINDO TODAS AS TAREFAS (POLIMORFISMO) ===");
        for (int i = 0; i < listaDeTarefas.length; i++) {
            listaDeTarefas[i].resumo();
        }
    }
}
