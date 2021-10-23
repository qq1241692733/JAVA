import javax.naming.NamingEnumeration;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/23
 * Time: 10:53
 */
public class ThreadDemo1 {
    /**
     * 自定义阻塞队列：
     *  生产者消费者模型 —— 生产者生产数据（添加元素），消费者消费生产的数据（取出数据）
     *  生产者：当数据量满了之后，不要尝试给队列添加数据了，而是 阻塞等待 wait()/ notify/ notfiyAll/ LockSupport park/ unpank(t)
     *
     * 消费者：当队列为空的时候就阻塞等待
     */
    static class MyBlockingQueue {
        private int[] values; // 实际存储数据的数组
        private int first;  // 队首
        private int last;  // 队尾
        private int size;  // 队列元素实际大小

        public MyBlockingQueue(int initial) {
            // 初始化
            values = new int[initial];
            first = 0;
            last = 0;
            size = 0;
        }

        // 生产者添加元素方法（队尾）
        public void offer(int val) {
            synchronized (this) {
                // 判断边界值
                if (size == values.length) {
                    // 队列已满
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 添加元素
                values[last++] = val;
                size ++;

                // 判断是否最后一个元素
                if (last == values.length) {
                    last = 0;
                }

                // 尝试唤醒消费者
                this.notify();
            }
        }

        // 消费者查询方法
        public int poll() {
            int result = -1;
            synchronized (this) {
                // 判断边界值
                if (size == 0) {
                    // 队列为空
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 取元素
                result = values[first++];
                size --;

                // 判断是否为最后一个元素
                if (first == values.length) {
                    first = 0;
                }
                // 尝试唤醒生产者
                this.notify();
            }
            return result;
        }

    }
    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(100);

        // 生产者
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 每隔 500ms 生产一条数据
                while (true) {
                    int num = new Random().nextInt(10);
                    System.out.println("生产了随机数：" + num);
                    myBlockingQueue.offer(num);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        // 消费者
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int result = myBlockingQueue.poll();
                    System.out.println("消费了数据：" + result);
                }
            }
        });
        t2.start();
    }
}
