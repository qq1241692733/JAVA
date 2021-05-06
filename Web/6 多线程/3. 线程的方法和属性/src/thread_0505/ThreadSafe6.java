package thread_0505;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/5
 * Time: 21:37
 */
public class ThreadSafe6 {
    public static void main(String[] args) throws InterruptedException {
        // 默认非公平锁  true公平锁   false非公平锁
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

        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        Thread.sleep(10);
        t1.start();
        t2.start();
    }
}
