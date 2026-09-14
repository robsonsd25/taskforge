package src.exercicios.modulo01.aula01;

public class Exercicio01 {

    public static void main(String[] args) {
        int idade = Integer.parseInt(IO.readln("Sua idade: "));

        if (idade >= 18) {
            System.out.println("Você é maior de idade.");
        } else {
            System.out.println("Você é menor de idade.");
        }
    }
}