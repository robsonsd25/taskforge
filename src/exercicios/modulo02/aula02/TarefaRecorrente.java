package src;

public class TarefaRecorrente extends Tarefa implements Notificavel {


    private int vezesPorSemana;


    public TarefaRecorrente(String nome, String descricao, int prioridade, String responsavel,
                            double horasEstimadas, TarefaStatus status, int vezesPorSemana) {
        super(nome, descricao, prioridade, responsavel, horasEstimadas, status);
        this.vezesPorSemana = vezesPorSemana;
    }


    @Override
    public String tipo() {
        return "TAREFA RECORRENTE";
    }


    @Override
    public void resumo() {
        super.resumo();
        IO.println("Frequência: " + this.vezesPorSemana + "x por semana");
    }


    @Override
    public String notificar() {
        return "Aviso de Rotina: '" + getNome() + "' precisa ser feita " + vezesPorSemana + " vezes esta semana!";
    }


    public int getVezesPorSemana() { return vezesPorSemana; }
    public void setVezesPorSemana(int vezesPorSemana) { this.vezesPorSemana = vezesPorSemana; }
}
