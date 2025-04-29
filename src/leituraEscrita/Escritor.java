package leituraEscrita;

public class Escritor extends Thread {
    private final RecursoCompartilhado recurso;
    private final int id;

    public Escritor(int id, RecursoCompartilhado recurso) {
        this.id = id;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        try {
            while (true) {
                recurso.iniciarEscrita();
                System.out.println("Escritor " + id + " iniciou escrita");
                int novo = (int)(Math.random() * 1000);
                System.out.println("Escritor " + id + " escrevendo: " + novo);
                recurso.escrever(novo);
                Thread.sleep((long)(Math.random() * 800));
                System.out.println("Escritor " + id + " terminou escrita");
                recurso.terminarEscrita();
                Thread.sleep((long)(Math.random() * 1200));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}