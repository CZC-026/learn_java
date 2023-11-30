package learn_juc.CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class WelcomeApp {
    public static void main(String[] args) {
        WelcomeThread welcomeThread = new WelcomeThread();
        welcomeThread.start();
        Thread welcomeThread2 = new Thread(new WelcomeRunnable());
        welcomeThread2.start();

        Future<String> futureTask = new FutureTask<>(new WelcomeCallable());
        FutureTask<String> futureTask2 = new FutureTask<>(new WelcomeCallable());
        //futureTask实现了Runnable和Future接口，所以可以作为Thread的target
//        Thread welcomeThread3 = new Thread(futureTask);
        Thread welcomeThread4 = new Thread(futureTask2);
        welcomeThread4.start();
        try {
            String res = futureTask2.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


}




class WelcomeThread extends Thread{
    @Override
    public void run(){
        System.out.println("1.Welcome! I'm "+Thread.currentThread().getName());
    }
}

class WelcomeRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("2.Welcome! I'm "+Thread.currentThread().getName());
    }
}

class WelcomeCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        return "Welcome! I'm "+Thread.currentThread().getName()+"\n";
    }
}
