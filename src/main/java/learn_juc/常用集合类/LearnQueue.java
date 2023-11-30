package learn_juc.常用集合类;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LearnQueue {

    static final BlockingQueue<String> blockingQueue1 = new LinkedBlockingQueue<>();
    static final BlockingQueue<String> blockingQueue2 = new ArrayBlockingQueue<>(10);

    static final Queue<String> queue1 = new LinkedList<>();
    static final Queue<String> queue2 = new PriorityQueue<>();

    public static void main(String[] args) {
        /**
         * offer，poll/add , remove,前者在失败时返回false和null,后者在失败时抛出异常
         */
        blockingQueue1.add("1");
        blockingQueue1.offer("2");
        blockingQueue1.remove();
        blockingQueue1.poll();
        try {
            String ele = blockingQueue1.remove();
            System.out.println(ele);
        } catch (NoSuchElementException e) {
            //在抛出异常时，打印出队列为空的提示
            System.out.println("Queue is empty. Cannot remove element.");
            e.printStackTrace();
        }
        /**
         * take和put
         */
        try {
            blockingQueue1.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            blockingQueue1.put("czc");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}


class MyBlockingQueue{
    private int capacity;
    private ArrayList<String> list;

    private Object lock = new Object();

    public MyBlockingQueue(int capacity){
        this.capacity = capacity;
    }
    public void put(String str) throws InterruptedException {
        synchronized (lock){
            while (list.size() == capacity){
                lock.wait();
            }
            list.add(str);
            lock.notify();
        }
    }
    public void take() throws InterruptedException {
        synchronized (lock){
            while (list.size() == 0){
                lock.wait();
            }
            list.remove(0);
            lock.notify();
        }
    }

}
