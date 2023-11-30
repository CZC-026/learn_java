package learn_juc.死锁;

public class DeadLock1 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread a = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){

                }
            }
        });
        Thread b = new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1){

                };
            }
        });
        a.start();
        b.start();
    }
}
