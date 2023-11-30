package learn_juc.CreateThread;

import java.util.concurrent.CountDownLatch;

public class ThreadCreationCmp {
    public static void main(String[] args) {
        Thread t;
        CountingTask task = new CountingTask(new Counter());
//        final int numberOfProcessors = Runtime.getRuntime().availableProcessors()
        for (int i = 0; i < 100; i++) {
            t = new Thread(task);
            t.start();

        }
        for (int i = 0; i < 5; i++) {
            t = new CountingThread(new Counter());
            t.start();
        }

    }

    /**
     * static只能修饰内部类，不能修饰外部类
     */
    static class Counter {
        private int count = 0;
        public synchronized void increment() {
            count++;
        }
        public int getCount() {
            return count;
        }
    }
    static class CountingTask implements Runnable{
        //注入计数器
        private Counter counter;
        public CountingTask(Counter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++) {
                counter.increment();
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("CountingTask:"+counter.getCount());
        }
    }
    static class CountingThread extends Thread{
        private Counter counter;
        public CountingThread(Counter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++) {
                counter.increment();
                try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("CountingThread:"+counter.getCount());
        }
    }

}
