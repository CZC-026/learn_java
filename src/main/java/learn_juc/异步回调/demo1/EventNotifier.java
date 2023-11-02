package learn_juc.异步回调.demo1;

public class EventNotifier {
    public void doSomething(CallBack callBack){
        //模拟一个异步操作
        Thread a = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String res = "complete signal";
            //异步操作完成后调用回调函数,通知调用者线程
            callBack.onComplete(res);
        });
        a.start();
        //主程序可以在这里做其他事情
        System.out.println("异步  do other things");
    }

    public static void main(String[] args) {
        EventNotifier eventNotifier = new EventNotifier();
        //eventNotifier执行异步操作，并将执行结果通过回调函数返回
        eventNotifier.doSomething(new MyCallBack());
        System.out.println("主线程继续执行");
    }
}
