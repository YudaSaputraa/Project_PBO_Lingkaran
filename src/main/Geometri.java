package main;

public class Geometri {

    public static void main(String[] args) {

        Thread[] threads = new Thread[8];
        threads[0] = new Thread(new LingkaranThread());
        threads[1] = new Thread(new TabungThread());
        threads[2] = new Thread(new KerucutThread());
        threads[3] = new Thread(new KerucutTerpancungThread());
        threads[4] = new Thread(new BolaThread());
        threads[5] = new Thread(new JuringThread());
        threads[6] = new Thread(new TemberengBolaThread());
        threads[7] = new Thread(new KeratanBolaThread());

        for (Thread thread : threads) {
            thread.start();
        }
    }

}
