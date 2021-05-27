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
public class ThreadDemo1 {
    // 有100
    private static AtomicReference money =
            new AtomicReference(100);

    public static void main(String[] args) {
        // 转出100
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean re = money.compareAndSet(100,0);
                System.out.println(re);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean re = money.compareAndSet(100,0);
                System.out.println(re);
            }
        });
        t2.start();
    }
}
