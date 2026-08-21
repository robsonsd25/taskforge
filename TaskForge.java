void main() {
    IO.println("=== TaskForge v0 ===");

    String nome = IO.readln("Nome da tarefa: ");
    String descricao = IO.readln("Descrição: ");

    int prioridade = Integer.parseInt(
            IO.readln("Prioridade (1 a 5): ")
    );

    while (prioridade < 1 || prioridade > 5) {
        IO.println("ERRO: A prioridade deve ser um número entre 1 e 5.");

        prioridade = Integer.parseInt(
                IO.readln("Digite novamente a prioridade (1 a 5): ")
        );
    }

    String responsavel = IO.readln("Responsável: ");
    double horasEstimadas = Double.parseDouble(
            IO.readln("Horas estimadas: ")
    );

    String status = "pendente";

    IO.println("");
    IO.println("------ TAREFA CRIADA ------");
    IO.println("Tarefa:     " + nome);
    IO.println("Descrição:  " + descricao);
    IO.println("Prioridade: " + prioridade);
    IO.println("Status:     " + status);
    IO.println("---------------------------");
}