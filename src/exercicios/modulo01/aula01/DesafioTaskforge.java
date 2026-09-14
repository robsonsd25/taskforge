package src.exercicios.modulo01.aula01;

public class DesafioTaskforge {

    public static void main(String[] args) {
        int opcao;
        int totalTarefas = 0;

        do {

            System.out.println("\n--- TaskForge ---");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Ver resumo");
            System.out.println("3 - Sair");
            opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));


            switch (opcao) {
                case 1:
                    int prioridade;

                    do {
                        prioridade = Integer.parseInt(IO.readln("Prioridade da tarefa (1 a 5): "));
                        if (prioridade < 1 || prioridade > 5) {
                            System.out.println("Prioridade inválida! Digite um número de 1 a 5.");
                        }
                    } while (prioridade < 1 || prioridade > 5);

                    System.out.print("Tarefa criada com prioridade: ");
                    for (int i = 1; i <= prioridade; i++) {
                        System.out.print("*");
                    }
                    System.out.println(); // Pula linha

                    totalTarefas++;
                    break;

                case 2:

                    System.out.println("Total de tarefas criadas até agora: " + totalTarefas);
                    break;

                case 3:
                    System.out.println("Saindo do programa... Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
                    break;
            }

        } while (opcao != 3);
    }
}
