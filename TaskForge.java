// TaskForge - Do Código ao Contrato
// Código final da aula 3.2: EXCEÇÕES + LAMBDAS + STREAMS.
// Agora o programa nao quebra mais na cara do usuario.

import src.Tarefa;
import src.TarefaComPrazo;
import src.TarefaSimples;
import src.TarefaStatus;
import src.Notificavel;
import src.TarefaInvalidaException;

import java.util.ArrayList;
import java.util.List;

void main() {
    List<Tarefa> listaTarefa = new ArrayList<>();

    // Tarefas de exemplo pra ter o que filtrar
    listaTarefa.add(new TarefaSimples("Estudar Java", "Exceções", 1,
            "Lander", 2, TarefaStatus.EM_ANDAMENTO));
    listaTarefa.add(new TarefaComPrazo("Entregar PR", "Desafio da 3.2", 3,
            "Lander", 4, TarefaStatus.PENDENTE, 48));
    listaTarefa.add(new TarefaSimples("Configurar o Git", "Chave SSH", 2,
            "Lander", 1, TarefaStatus.CONCLUIDA));

    int opcao = 0;
    do {
        IO.println();
        IO.println("=== TaskForge ===");
        IO.println("1 - Criar tarefa");
        IO.println("2 - Listar tarefas");
        IO.println("3 - Só as pendentes");
        IO.println("4 - Sair");

        // BLOCO 1: o parseInt quebra se o usuario digitar letra.
        // O try/catch e o cinto de seguranca: o programa avisa e CONTINUA.
        try {
            opcao = Integer.parseInt(IO.readln());
        } catch (NumberFormatException e) {
            IO.println("Isso não é um número. Digite de 1 a 4.");
            continue;   // volta pro comeco do laco
        }

        switch (opcao) {
            case 1 -> {
                // BLOCO 2: aqui pode estourar a NOSSA excecao
                try {
                    listaTarefa.add(criarTarefa());
                    IO.println("Tarefa criada! Total: " + listaTarefa.size());
                } catch (TarefaInvalidaException e) {
                    // getMessage() traz o texto que a gente escreveu no throw
                    IO.println("Não deu pra criar: " + e.getMessage());
                }
            }
            case 2 -> listar(listaTarefa);
            case 3 -> listarPendentes(listaTarefa);
            case 4 -> IO.println("Até a próxima!");
            default -> IO.println("Opção inválida.");
        }
    } while (opcao != 4);
}

// THROWS: o metodo avisa que PODE estourar. Quem chamar e obrigado a tratar.
Tarefa criarTarefa() throws TarefaInvalidaException {
    String nome = IO.readln("Nome da tarefa: ");

    // THROW: a gente MESMO dispara a excecao quando a regra do negocio e quebrada
    if (nome == null || nome.isBlank()) {
        throw new TarefaInvalidaException("o nome não pode ficar vazio.");
    }

    int prioridade;
    try {
        prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));
    } catch (NumberFormatException e) {
        throw new TarefaInvalidaException("a prioridade tem que ser um número.");
    }

    if (prioridade < 1 || prioridade > 5) {
        throw new TarefaInvalidaException("a prioridade tem que estar entre 1 e 5.");
    }

    // AO VIVO a gente para aqui: devolve sempre uma TarefaSimples.
    // Deixar o usuario ESCOLHER o tipo (e poder criar uma TarefaComPrazo
    // pelo menu, que ai notifica) e o EXTRA do desafio.
    // Por enquanto, a TarefaComPrazo do exemplo la em cima e quem mostra
    // o notificar() funcionando na opcao 2.
    return new TarefaSimples(nome, "sem descrição", prioridade,
            "Lander", 2, TarefaStatus.PENDENTE);
}

void listar(List<Tarefa> tarefas) {
    if (tarefas.isEmpty()) {
        IO.println("Nenhuma tarefa cadastrada.");
        return;
    }

    // forEach + LAMBDA: "para cada t, faca..."
    tarefas.forEach(t -> {
        t.resumo();

        // AQUI A INTERFACE TRABALHA:
        // "essa tarefa assinou o contrato Notificavel?"
        // A TarefaSimples nao assinou -> passa batido, sem erro.
        // A TarefaComPrazo assinou -> notifica.
        if (t instanceof Notificavel n) {
            IO.println(n.notificar());
        }
        IO.println("---------------------------");
    });
}

void listarPendentes(List<Tarefa> tarefas) {
    // STREAM: a esteira. filter escolhe, forEach faz.
    // Leia como uma frase: "da lista, FILTRE as pendentes, e pra CADA UMA imprima o nome".
    tarefas.stream()
            .filter(t -> t.getStatus() == TarefaStatus.PENDENTE)
            .forEach(t -> IO.println("- " + t.getNome()));
}