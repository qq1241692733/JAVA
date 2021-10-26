package cas;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/26
 * Time: 16:25
 */
public class ThreadDemo1 {
    /**
     * Atomic（乐观锁）
     */
    private static AtomicInteger count = new AtomicInteger(0);
    // 最大循环数
    private static final int MAXSIZE = 100000;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE; i++) {
                    count.getAndIncrement();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < MAXSIZE; i++) {
                    count.getAndDecrement();
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println(count);

//        AtomicInteger count = new AtomicInteger(0);
//        count.getAndIncrement();  // count++
//        count.incrementAndGet();  // ++count
//        System.out.println(count.incrementAndGet());

    }
}
