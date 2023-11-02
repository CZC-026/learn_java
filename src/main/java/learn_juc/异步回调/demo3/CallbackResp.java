package learn_juc.异步回调.demo3;

public class CallbackResp {
    public void handler(CallBack callBack , String req){
        System.out.println(callBack.getClass()+"问的问题是：" + req);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res =  "答案是2";
        callBack.solve(res);
    }
}
