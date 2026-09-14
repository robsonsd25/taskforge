package src.exercicios.modulo03.aula02;

import java.util.ArrayList;
import java.util.List;

// 1. Esta é a classe principal que dá nome ao arquivo. O main fica direto nela!
public class DesafioAlula0302 {
    public static void main(String[] args) {

        // 5. Tente instanciar a classe abstrata diretamente:
        // Forma teste = new Forma("teste");
        // ❌ ERRO DO COMPILADOR: "Forma is abstract; cannot be instantiated"

        // 4. Criando a lista de Formas e usando o for-each
        List<Forma> formas = new ArrayList<>();

        formas.add(new Circulo("Círculo Pequeno", 2.0));
        formas.add(new Quadrado("Quadrado Grande", 5.0));

        System.out.println("--- Mostrando as Áreas ---");
        for (Forma forma : formas) {
            forma.mostrar(); // A mãe chama o método que as filhas escreveram!
        }
    }
}

// =======================================================
// AS CLASSES ABAIXO FICAM FORA DA CLASSE PRINCIPAL
// =======================================================

// 1. Classe abstrata Forma
abstract class Forma {
    protected String nome;

    // Construtor
    public Forma(String nome) {
        this.nome = nome;
    }

    // Método abstrato (sem corpo, termina com ;)
    public abstract double area();

    // 2. Método comum que chama o método abstrato
    public void mostrar() {
        System.out.println(this.nome + ": " + this.area());
    }
}

// 3. Classe Circulo que herda de Forma
class Circulo extends Forma {
    private final double raio;

    public Circulo(String nome, double raio) {
        super(nome);
        this.raio = raio;
    }

    // Implementação obrigatória do método area()
    @Override
    public double area() {
        return 3.14 * raio * raio;
    }
}

// 3. Classe Quadrado que herda de Forma
class Quadrado extends Forma {
    private double lado;

    public Quadrado(String nome, double lado) {
        super(nome);
        this.lado = lado;
    }

    // Implementação obrigatória do método area()
    @Override
    public double area() {
        return lado * lado;
    }
}
