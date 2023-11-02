package learn_juc.异步回调.demo3;

public class CallbackRequest implements CallBack{
    private CallbackResp callbackResp;

    public CallbackRequest(CallbackResp callbackResp) {
        this.callbackResp = callbackResp;
    }
    //主调将问题交给被调处理，被调异步处理逻辑
    public void request(String req){
        System.out.println("请求者的问题是：" + req);
        Thread a = new Thread(()->{
            callbackResp.handler(this,req);
        });
        a.start();
        System.out.println("请求者的问题已经交给被调处理,主调可以干其他事情了");
    }

    @Override
    public void solve(String result) {
        System.out.println("回调者的答案是：" + result);
    }

    public static void main(String[] args) {

    }
}
