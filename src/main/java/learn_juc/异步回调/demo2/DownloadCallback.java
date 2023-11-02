package learn_juc.异步回调.demo2;

public interface DownloadCallback {
    void onDownloadComplete(String result);
}
