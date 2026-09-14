package src.exercicios.modulo01.aula01;

public class Exercicio03 {

    public static void main(String[] args) {
        String senha;

        do {
            senha = IO.readln("Senha: ");

            if (!senha.equals("Curso01")) {
                System.out.println("Senha inválida!");
            }

        } while (!senha.equals("Curso01"));

        System.out.println("Acesso liberado!");
    }
}
