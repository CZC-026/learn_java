package learn_juc.异步回调.demo2;

import java.io.StringReader;

public class FileDownloader {
    public void download(String url, DownloadCallback callback) {
        Thread a = new Thread(()->{
            //模拟下载文件
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result ="异步通知主程序"+ url + "下载成功";
            callback.onDownloadComplete(result);
        });
        a.start();
    }

    public static void main(String[] args) {
        //注册回调函数
        FileDownloader fileDownloader = new FileDownloader();
        DownloadHandler downloadHandler = new DownloadHandler();
        fileDownloader.download("https://www.baidu.com",downloadHandler);
        try {
            //等待文件下载完成
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
