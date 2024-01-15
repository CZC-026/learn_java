package learn_juc.learn_volatile;

public class 有序性 {
    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();
        new Thread(()->{

            volatileExample.writer();
        }).start();
        new Thread(()->{
            volatileExample.reader();
        }).start();

    }
}


//假设线程A执行writer方法，线程B执行reader方法
class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a = 1;              // 1 线程A修改共享变量
        flag = true;        // 2 线程A写volatile变量
    }

    public void reader() {
        if (flag) {         // 3 线程B读同一个volatile变量
            int i = a;          // 4 线程B读共享变量
        }
        System.out.println("Read Result:" +  a);
    }
    public void print(){;
    }
}

