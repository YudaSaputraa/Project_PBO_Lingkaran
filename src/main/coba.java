package main;

import java.util.ArrayList;
import java.util.List;

public class coba {
    private static final int DATA_SIZE = 1000;
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {
        List<Integer> data = generateData(DATA_SIZE);
        List<ProcessingThread> threads = new ArrayList<>();

        // Membagi data menjadi sejumlah thread yang akan diproses
        int dataSizePerThread = DATA_SIZE / THREAD_COUNT;
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * dataSizePerThread;
            int endIndex = (i + 1) * dataSizePerThread;
            List<Integer> threadData = data.subList(startIndex, endIndex);
            ProcessingThread thread = new ProcessingThread(threadData);
            threads.add(thread);
        }

        // Memulai semua thread untuk memproses data secara paralel
        for (ProcessingThread thread : threads) {
            thread.start();
        }

        // Menunggu semua thread selesai
        for (ProcessingThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Proses selesai!");
    }

    private static List<Integer> generateData(int size) {
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            data.add(i);
        }
        return data;
    }

    private static class ProcessingThread extends Thread {
        private List<Integer> data;

        public ProcessingThread(List<Integer> data) {
            this.data = data;
        }

        @Override
        public void run() {
            for (Integer num : data) {
                // Proses data di sini
                System.out.println("Data: " + num + " - Thread: " + Thread.currentThread().getName());
            }
        }
    }
}
