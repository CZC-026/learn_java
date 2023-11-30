package learn_juc.等待阻塞与休眠;

public class JoinExample1 {
    private static class A extends Thread{
        @Override
        public void run() {
            System.out.println("ThreadA start running");
            //doSomethingOthers
            while (true){
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "is on Loop");
                } catch (InterruptedException e) {
                    System.out.println("ThreadA is interrupted");
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class B extends Thread{
        private A a;
        public B(A a){
            this.a = a;
        }
        @Override
        public void run() {
            try {
                a.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadB start running");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B(a);
        b.start();
        /**
         * 如何join的时候 线程还没有启动，就不会阻塞
         * Tests if this thread is alive. A thread is alive if it has
         * been started and has not yet died.
         */
//        Thread.sleep(1000);
        a.start();
        Thread.sleep(5000);
        a.interrupt();
        System.out.println(a.isInterrupted());
    }


}
