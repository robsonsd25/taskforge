package src.exercicios.modulo01.aula01;

public class Exercicio02 {

    public static void main(String[] args) {
        int n = Integer.parseInt(IO.readln("Número: "));

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}
