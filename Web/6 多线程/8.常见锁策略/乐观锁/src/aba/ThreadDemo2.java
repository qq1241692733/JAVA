package aba;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/27
 * Time: 19:50
 */
public class ThreadDemo2 {
    // 有100
    private static AtomicReference money =
            new AtomicReference(100);
    public static void main(String[] args) throws InterruptedException {
        // 转出100
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean re = money.compareAndSet(100,0);
                System.out.println(re);
            }
        });
        t1.start();
        t1.join();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // +100;
                boolean re = money.compareAndSet(0,100);
                System.out.println(re);
            }
        });
        t3.start();
        t3.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean re = money.compareAndSet(100,0);
                System.out.println(re);
            }
        });
        t2.start();
        t3.join();
    }
}
