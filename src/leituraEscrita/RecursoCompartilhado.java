package leituraEscrita;

import java.util.concurrent.Semaphore;

public class RecursoCompartilhado {
    private int dado = 0;
    private int leitoresAtivos = 0;
    
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore escritaBloqueio = new Semaphore(1);
    private final Semaphore leituraTentativa = new Semaphore(1);

    public void iniciarLeitura() throws InterruptedException {
        leituraTentativa.acquire();
        leituraTentativa.release();

        mutex.acquire();
        leitoresAtivos++;
        if (leitoresAtivos == 1) {
            escritaBloqueio.acquire();
        }
        mutex.release();
    }

    public void terminarLeitura() throws InterruptedException {
        mutex.acquire();
        leitoresAtivos--;
        if (leitoresAtivos == 0) {
            escritaBloqueio.release();
        }
        mutex.release();
    }

    public int ler() {
        return dado;
    }

    public void iniciarEscrita() throws InterruptedException {
        leituraTentativa.acquire();
        escritaBloqueio.acquire();
    }

    public void terminarEscrita() {
        leituraTentativa.release();
        escritaBloqueio.release();
    }

    public void escrever(int novoDado) {
        dado = novoDado;
    }
}