package br.com.docodigoaocontrato.taskforge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer prioridade;

    private Boolean concluida;

    public Tarefa(String nome, Integer prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public Tarefa() {
    }
}