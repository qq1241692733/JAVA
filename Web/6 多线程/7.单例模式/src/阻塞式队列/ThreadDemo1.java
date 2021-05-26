package 阻塞式队列;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/25
 * Time: 21:20
 */
public class ThreadDemo1 {
    static class MyBlockingQueue {
        private int[] values;
        private int first;
        private int last;
        private int size;
        public MyBlockingQueue(int initial) {
            values = new int[initial];
            first = 0;
            last = 0;
            size = 0;
        }
        // 添加元素(队伍)
        public void offer(int val) {
            // 判断边界值
            if (size == values.length) {
                // 队列已满 阻塞等待
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 添加元素到队伍
                values[last ++] = val;
                size ++;
                // 判断是否最好一个元素
                if (last == values.length) {
                    last = 0;
                }
                this.notify();
            }
        }

        // 查询方法
        public int poll() {
            int result = -1;
            synchronized (this) {
                if (size == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 取元素
                result = values[first ++];
                size -- ;
                // 判断最后一个元素
                if (first == values.length) {
                    first = 0;
                }
                this.notify();
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 每隔 500ms 生产一条数据
                while (true) {
                    int num = new Random().nextInt(10);
                    System.out.println("生产者: " +num);
                }
            }
        });
        t1.start();
        // 创建消费者
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int result =
                }
            }
        })
    }
}
