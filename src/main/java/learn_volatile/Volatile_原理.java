package learn_volatile;
/**
 * volatile的原理
 * 1.可见性原理：基于内存屏障：任何指令不能和Memory Barrier指令重排序
 * 2.对声明了volatile的变量进行写操作，vjm会向处理器发送一条带lock前缀的指令，将存在缓存里的数据写回到系统内存
 * lock指令会对总线进行锁定，其他cpu对内存读写会被阻塞
 * 3.为了实现各个cpu的缓存一致，cpu实现了缓存一致性协议，通过嗅探总线上的数据判断自己的总线是否过期，
 * 发现内存地址数据修改后，会将当前缓存设置为无效状态，下次从内存里读
 *
 *
 * 1.确保指令重排序时不会吧后边的指令放在内存屏障之前，也不会把前面的放在屏障之后，即直行道屏障这里，前面的操作已经完成
 * 2.强制将修改的操作立即写入主存
 * 3.写操作会导致其他cpu 的缓存无效
 */
public class Volatile_原理 {
}


class Test {
    private volatile int a;
    public void update() {
        a = 1;
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.update();
    }
}
