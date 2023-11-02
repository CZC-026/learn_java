package learn_juc.异步回调.demo2;

public class DownloadHandler implements DownloadCallback{
    @Override
    public void onDownloadComplete(String result) {
        //进行功能增强
        System.out.println("DownloadHandler: " + result);
    }
}
