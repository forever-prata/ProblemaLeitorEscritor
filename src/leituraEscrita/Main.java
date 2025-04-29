package leituraEscrita;

public class Main {
    public static void main(String[] args) {
        RecursoCompartilhado recurso = new RecursoCompartilhado();

        for (int i = 0; i < 5; i++) {
            new Leitor(i, recurso).start();
        }

        for (int i = 0; i < 3; i++) {
            new Escritor(i, recurso).start();
        }
    }
}
