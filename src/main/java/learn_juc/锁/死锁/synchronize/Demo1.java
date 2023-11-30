package learn_juc.锁.死锁.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public void func1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                demo1.func1();
            }
        });
        executorService.execute(()-> demo1.func1());
        executorService.shutdown();
    }
}
