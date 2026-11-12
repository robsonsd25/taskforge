package src.exercicios.modulo04;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Exercicio04ClimaDTO {

    private String cidade;
    private double temperaturaC;
    private boolean chovendo;
    private List<Exercicio04PrevisaoDTO> previsao;


}
