package learn_juc.learn_tl;

import java.util.concurrent.*;

/**
 * 使用线程池，线程复用，如果没有remove掉threadlocal，存在线程安全问题
 */
public class Demo内存泄露 {
}

class ThreadLocalDemo{
    static class LocalVariable{
        private Long[] a = new Long[1024*1024];
    }
//    final static ExecutorService executorService = Executors.newFixedThreadPool(16);
    final static ExecutorService executorService = new ThreadPoolExecutor(5,5,1, TimeUnit.MINUTES,new LinkedBlockingQueue<>(10));
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        for(int i=0;i<50;i++){
            executorService.execute(()->{
                localVariable.set(new LocalVariable());
                System.out.println("use local variable" + localVariable.get());
                localVariable.remove();
            });
            Thread.sleep(1000);
        }
        System.out.println("pool execute over");
    }

}

