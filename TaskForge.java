// TaskForge v0 - projeto do curso "Do Código ao Contrato"
// Aula 01.1: Java, a JVM e as primeiras variáveis.
//
// Este é o ponto de partida. Durante a aula você constrói este código,
// e no desafio você evolui ele (veja COMO-ENTREGAR.md).
//
// Como rodar:
//   - No IntelliJ: abra este arquivo e clique em Run.
//   - No terminal: java TaskForge.java

void main() {
    IO.println("=== TaskForge v0 ===");

    String nome = IO.readln("Nome da tarefa: ");
    String descricao = IO.readln("Descrição: ");
    int prioridade = Integer.parseInt(IO.readln("Prioridade (1 a 5): "));

    IO.println("");
    IO.println("------ TAREFA CRIADA ------");
    IO.println("Tarefa:     " + nome);
    IO.println("Descrição:  " + descricao);
    IO.println("Prioridade: " + prioridade);
    IO.println("Status:     pendente");
    IO.println("---------------------------");
}
