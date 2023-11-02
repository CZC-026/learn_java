package learn_juc.异步回调.demo1;

public class MyCallBack implements CallBack{
    @Override
    public void onComplete(String result) {
        System.out.println("Callback result is "+result);
        //接收到异步操作的结果后,做后续的操作
        System.out.println("做后续的事情");
    }
}
