package learn_juc.线程池;

import java.util.concurrent.*;

public class ComExecAndSubm {
    final static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Runnable runnable1 = () -> System.out.println("Runnable1 Task");
        Callable<Object> callable1 = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("Callable1 Task");
                return null;
            }
        };
        executorService.execute(runnable1);
        executorService.execute(new FutureTask<>(callable1));
        Future<?> future1 = executorService.submit(runnable1);
        Future<Object> future2 = executorService.submit(callable1);
    }

}
