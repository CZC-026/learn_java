package learn_juc.learn_volatile;


public class HungrySingleton {
    private volatile static HungrySingleton hungrySingleton;
    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        if(hungrySingleton == null){
            synchronized (HungrySingleton.class){
                if(hungrySingleton == null){
                    hungrySingleton = new HungrySingleton();
                }
            }
        }
        return hungrySingleton;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(()->{
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                HungrySingleton instance = HungrySingleton.getInstance();
                System.out.println(instance);
            });
            thread.start();

        }
    }
}
