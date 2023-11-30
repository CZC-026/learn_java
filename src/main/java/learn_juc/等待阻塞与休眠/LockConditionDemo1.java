package learn_juc.等待阻塞与休眠;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionDemo1 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        LockConditionDemo1 demo1 = new LockConditionDemo1();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()-> demo1.after());
        Thread.sleep(100);
        executorService.execute(() -> demo1.before());
    }
    public void before(){
        lock.lock();
        try {
            System.out.println("Do something before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public void after(){
        lock.lock();
        try{
            condition.await();
            Thread.sleep(1000);
            System.out.println("Do something After");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(2);
            lock.unlock();
            System.out.println(3);
        }
        System.out.println(1);

    }
}
