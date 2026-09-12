package br.com.docodigoaocontrato.taskforge.modulo03.aula02;

import java.util.ArrayList;
import java.util.List;

public class DesafioAula0302 {
    public static void main(String[] args) {

        List<Tarefa> tarefas = new ArrayList<>();


        tarefas.add(new TarefaSimples("Estudar Java", TarefaStatus.PENDENTE));
        tarefas.add(new TarefaComPrazo("Entregar projeto", TarefaStatus.CONCLUIDA, "15/09"));
        tarefas.add(new TarefaRecorrente("Academia", TarefaStatus.PENDENTE, 2));

        System.out.println("--- 2. Percorrendo todas com resumo() ---");
        for (Tarefa t : tarefas) {
            System.out.println(t.resumo());
        }

        System.out.println("\n--- 3. Listar Pendentes ---");
        // Percorre a lista e imprime apenas as que estão PENDENTE
        for (Tarefa t : tarefas) {
            if (t.getStatus() == TarefaStatus.PENDENTE) {
                System.out.println("[PENDENTE] " + t.resumo());
            }
        }
    }
}


class TarefaRecorrente extends Tarefa {
    private int diasIntervalo; // Campo exclusivo dela

    // Construtor
    public TarefaRecorrente(String titulo, TarefaStatus status, int diasIntervalo) {
        super(titulo, status); // Passa os dados obrigatórios para a mãe
        this.diasIntervalo = diasIntervalo;
    }


    @Override
    public String tipo() {
        return "Recorrente";
    }


    @Override
    public String resumo() {
        return getTitulo() + " (Repete a cada " + diasIntervalo + " dias) - Status: " + getStatus();
    }
}


enum TarefaStatus {PENDENTE, CONCLUIDA}

abstract class Tarefa {
    private String titulo;
    private TarefaStatus status;

    public Tarefa(String titulo, TarefaStatus status) {
        this.titulo = titulo;
        this.status = status;
    }

    public abstract String tipo(); // O método abstrato citado no exercício

    public String resumo() {
        return titulo + " - Status: " + status;
    }

    public String getTitulo() {
        return titulo;
    }

    public TarefaStatus getStatus() {
        return status;
    }
}

class TarefaSimples extends Tarefa {
    public TarefaSimples(String titulo, TarefaStatus status) {
        super(titulo, status);
    }

    @Override
    public String tipo() {
        return "Simples";
    }
}

class TarefaComPrazo extends Tarefa {
    private String prazo;

    public TarefaComPrazo(String titulo, TarefaStatus status, String prazo) {
        super(titulo, status);
        this.prazo = prazo;
    }

    @Override
    public String tipo() {
        return "Com Prazo";
    }

    @Override
    public String resumo() {
        return getTitulo() + " [ALERTA PRAZO: " + prazo + "] - Status: " + getStatus();
    }
}
