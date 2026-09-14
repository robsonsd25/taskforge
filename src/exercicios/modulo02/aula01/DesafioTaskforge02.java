package src.exercicios.modulo02.aula01;

import src.TarefaComPrazo;
import src.TarefaStatus;

public class DesafioTaskforge02 {

    public static void main(String[] args) {

        TarefaComPrazo t2 = new TarefaComPrazo("Fazer café", "Passar um café quentinho", 3,
                "Dev", 0.5, TarefaStatus.PENDENTE, 12.0);

        t2.resumo();

        System.out.println("\n--- Atualizando a segunda tarefa... ---");
        t2.setStatus(TarefaStatus.EM_ANDAMENTO); // Atualiza usando o Enum correto
        t2.resumo();
    }
}
