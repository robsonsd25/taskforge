package br.com.docodigoaocontrato.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Long categoriaId;
    private Long usuarioId;
}