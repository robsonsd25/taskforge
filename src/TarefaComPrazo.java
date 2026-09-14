package src;

public class TarefaComPrazo extends Tarefa implements Notificavel {

    double tempoLimite;

    public TarefaComPrazo(String nome, String descricao, int prioridade, String responsavel,
                          double horasEstimadas, TarefaStatus status, double tempoLimite) {
        super(nome, descricao, prioridade, responsavel, horasEstimadas, status);
        this.tempoLimite = tempoLimite;
    }

    public String tipo() {
        return "tarefa com Prazo";
    }

    public void resumo() {
        super.resumo();
        IO.println("Tempo limite: " + this.tempoLimite);
    }

    public String notificar() {
        return "Lembrete: '" + getNome() + "' vence em " + tempoLimite + " horas!";
    }
}