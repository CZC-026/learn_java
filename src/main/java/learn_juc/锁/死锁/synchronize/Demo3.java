package learn_juc.锁.死锁.synchronize;
/**
 * 使用反编译生成.class文件
 * 1. javac -encoding utf-8 SynchronizedDemo2.java
 * 2. javap -v SynchronizedDemo2.class
 */
public class Demo3 {
    public static void main(String[] args) {
        Demo3 demo =  new Demo3();
        demo.method1();
    }

    private synchronized void method1() {
        System.out.println(Thread.currentThread().getId() + ": method1()");
        method2();
    }

    private synchronized void method2() {
        System.out.println(Thread.currentThread().getId()+ ": method2()");
        method3();
    }

    private synchronized void method3() {
        System.out.println(Thread.currentThread().getId()+ ": method3()");
    }
}


class SynchronizedDemo2 {


}

