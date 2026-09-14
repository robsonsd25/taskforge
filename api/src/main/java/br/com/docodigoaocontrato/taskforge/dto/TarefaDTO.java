package br.com.docodigoaocontrato.taskforge.dto;

public class TarefaDTO {

    private int id;
    private String titulo;
    private int prioridade;
    private boolean concluida;

        public TarefaDTO() {
    }


    public TarefaDTO(int id, String titulo, int prioridade, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
}
