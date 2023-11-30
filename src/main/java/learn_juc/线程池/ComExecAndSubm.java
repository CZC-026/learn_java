package learn_juc.线程池;

import java.util.concurrent.*;

public class ComExecAndSubm {
    final static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable1 = () -> System.out.println("Runnable1 Task");
        Callable<Object> callable1 = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("Callable1 Task");
                Thread.sleep(3000);
                return null;
            }
        };
        executorService.execute(runnable1);
        executorService.execute(new FutureTask<>(callable1));
        Future<?> future1 = executorService.submit(runnable1);
        Future<Object> future2 = executorService.submit(callable1);
        try {
            Object object = future1.get();
            System.out.println(object);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        try {
            //try里面的是局部变量，作用域
            Object object = future2.get();
            System.out.println(object);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        future2.cancel(true);
        Object object = future2.get();
        System.out.println(object);

        executorService.shutdown();
    }

}
