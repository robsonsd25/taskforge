package br.com.docodigoaocontrato.taskforge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {

    private Long id;
    private String descricao;
    private String autor;

    public ComentarioDTO(String descricao, Long id, String autor) {
        this.descricao = descricao;
        this.autor = autor;
    }
}
