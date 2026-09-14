package src;

public class TarefaSimples extends Tarefa {

    public TarefaSimples(String nome, String descricao, int prioridade, String responsavel,
                         double horasEstimadas, TarefaStatus status) {
        super(nome, descricao, prioridade, responsavel, horasEstimadas, status);
    }

    // So o tipo(): o resumo() da mae ja resolve o resto.
    public String tipo() {
        return "tarefa Simples";
    }
}