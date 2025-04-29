package leituraEscrita;

public class Leitor extends Thread {
    private final RecursoCompartilhado recurso;
    private final int id;

    public Leitor(int id, RecursoCompartilhado recurso) {
        this.id = id;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        try {
            while (true) {
                recurso.iniciarLeitura();
                System.out.println("Leitor " + id + " iniciou leitura");
                System.out.println("Leitor " + id + " leu: " + recurso.ler());
                Thread.sleep((long)(Math.random() * 500));
                System.out.println("Leitor " + id + " terminou leitura");
                recurso.terminarLeitura();
                Thread.sleep((long)(Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}