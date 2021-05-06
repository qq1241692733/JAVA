package thread_0505;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
        volatile 不能解决非原子性问题
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 18:07
 */
public class ThreadSafe4 {
   private static int number = 0;
   //最大长度
   private static final int maxSize = 100000;
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    lock.lock();
                    try {
                        number ++;
                    } finally {
                        lock.unlock();;
                    }
                    /**
                     * 如果将 lock（） 方法放在 try 里，那么当try里边的代码出现
                     * 异常后就会执行 finally 里的释放锁，但这个时候加锁还没成功
                     *如果将lock（） 方法放在 try 里，那么执行 finally 里释放锁代码
                     * 时就会报错，线程状态已成，释放锁的异常会覆盖掉业务代码的异常报错
                     */
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    lock.lock();
                    try {
                        number --;
                    } finally {
                        lock.unlock();;
                    }
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println(number);
    }
}

