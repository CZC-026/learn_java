package learn_juc.learn_tl;

import java.text.SimpleDateFormat;
import java.util.Date;

class Demo11 {
}

/**
 * 1.通过类将有状态的值和线程绑定
 */
class SerialNum{
    private static int nextSerialNum = 0;
    private static ThreadLocal<Integer> serialNum = new ThreadLocal<Integer>(){
        @Override
        protected synchronized Integer initialValue() {
            return nextSerialNum++;
        }
    };
    public static int get(){
        return serialNum.get();
    }
}
/**
 * 2.session的管理
 */
class Session{
    private String id;
    public Session(){
        this.id = "123";
    }
    public String getId(){
        return id;
    }
}

class DateUtil{
    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    public static String formatDate(Date date){
        return simpleDateFormatThreadLocal.get().format(date);
    }
}