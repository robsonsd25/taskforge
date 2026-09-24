package br.com.docodigoaocontrato.taskforge.dto;

public class TarefaDTO {
    private  int id;
    private String nome;

    public TarefaDTO(int id, String nome, int prioridade, boolean concluida) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    private int prioridade;
    private boolean concluida;
}
