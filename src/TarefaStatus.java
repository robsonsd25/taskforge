package src;

// ENUM: conjunto FIXO de valores com nome.
// O status deixou de ser um int solto (1, 2, 3, 4) — agora ele TEM nome.
// Repare que o enum pode ter atributo, construtor e metodo, igual a uma classe.
public enum TarefaStatus {

    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDA("Concluída"),
    CANCELADA("Cancelada");   // depois do ultimo valor vem o ponto e virgula

    private final String descricao;   // final = nunca muda depois de criado

    TarefaStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}