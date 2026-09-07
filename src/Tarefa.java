package src;

// 1. Tornamos a classe abstrata de forma correta
public abstract class Tarefa {

    // ATRIBUTOS
    private String nome;
    private String descricao;
    private int prioridade;
    private String responsavel;
    private double horasEstimadas;
    private TarefaStatus status; // Usa o Enum do seu projeto

    // CONSTRUTOR COM ARGUMENTOS
    public Tarefa(String nome, String descricao, int prioridade, String responsavel, double horasEstimadas, TarefaStatus status) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.responsavel = responsavel;
        this.horasEstimadas = horasEstimadas;
        this.status = status;
    }

    // Método abstrato que todas as filhas (como TarefaComPrazo) são obrigadas a ter
    public abstract String tipo();

    // Método de resumo unificado usando o IO do seu curso
    public void resumo() {
        IO.println("\n--- Resumo da Tarefa (" + tipo() + ") ---");
        IO.println("Tarefa: " + this.nome);
        IO.println("Descrição: " + this.descricao);

        // Mantive a lógica legal de mostrar as estrelinhas no resumo!
        System.out.print("Prioridade: ");
        for (int i = 1; i <= prioridade; i++) {
            System.out.print("*");
        }
        System.out.println();

        IO.println("Responsável: " + this.responsavel);
        IO.println("Horas Estimadas: " + this.horasEstimadas);
        IO.println("Status: " + this.status);
    }

    // MÉTODOS ACESSÓRIOS (GETTERS E SETTERS)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public double getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(double horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public void setStatus(TarefaStatus status) {
        this.status = status;
    }
}
