package learn_juc.锁.死锁.synchronize;

/**
 * 如果不是可重入锁，就会造成循环等待依赖，造成死锁
 */
public class 可重入锁 {
    public synchronized void method1(){
        System.out.println("method1 do something");
        method2();
    }

    private synchronized void method2() {
        System.out.println("method2 do something");
    }
}
