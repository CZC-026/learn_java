package learn_juc.线程池;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComIfShutdownNow {
    private static final ExecutorService es = Executors.newFixedThreadPool(1);


    public static void main(String[] args) {
        es.execute(() ->{
            try {
                Thread.sleep(2000);
                System.out.println("Thread is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        es.shutdown();
        boolean shutdown = es.isShutdown();
        System.out.println(shutdown);
        System.out.println(es.isTerminated());
        List<Runnable> list = es.shutdownNow();
        System.out.println(list.size());
        //只有shutdownNow()成功之后才会返回true
        System.out.println(es.isTerminated());
    }
}
