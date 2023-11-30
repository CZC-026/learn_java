package learn_juc.等待阻塞与休眠.交替打印;

/**
 * @author czc
 * @apiNote :输入一个数字n，交替打印1-n,实现一个功能类
 */
public class Print1 {
    private int upperCount;
    private volatile int count = 1;

    private boolean ifPrintOdd = false;
    public Print1(int n){
        this.upperCount = n;
    }

    public static void main(String[] args) {
        Print1 printer1 = new Print1(50);
        printer1.printApi();
    }
    public void printApi(){
        Thread thread1 = new Thread(()-> printJiShu());
        Thread thread2 = new Thread(()-> printOuShu());
        thread1.start();
        thread2.start();
    }
    private synchronized void printJiShu(){
        while (count <= upperCount) {
            while (count % 2 != 1){

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(count > upperCount){
                System.out.println("failure");
                return;
            }
            System.out.println(Thread.currentThread().getName() + ":"+ count);
            count++;
            this.notify();
        }


    }

    private synchronized void printOuShu(){
        while (count <= upperCount){
            while (count % 2 != 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(Thread.currentThread().getName() + ":" + count);
            count++;
            this.notify();
        }
    }

}
