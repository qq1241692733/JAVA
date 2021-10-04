package safe.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/4
 * Time: 19:08
 */
public class ThreadDemo8 {
    /**
     *  synchronized 锁机制是非公平锁
     *      公平锁可以按顺序进行执行，而非公平锁执行的效率更高，在 Java 中所有的锁默认的策略都
     *    是非公平锁，但是Lock 可以声明为公平锁
     */
    public static void main(String[] args) {
        // 声明一个公平锁
        Lock lock = new ReentrantLock(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (char item : "ABCD".toCharArray()) {
                    lock.lock();
                    try {
                        System.out.print(item);
                    } finally {
                        lock.unlock();
                    }

                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

    }
}
