package learn_juc.learn_interrupt;

public class InterruptExample {
    private static class MyThread1 extends Thread{
        @Override
        public void run(){
            while(true){
                System.out.println("Thread is running");
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Interrupted!");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted when sleep");
                    e.printStackTrace();

                }

            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        t1.start();
        t1.interrupt();
        System.out.println("Main thread is Running");
    }
}
