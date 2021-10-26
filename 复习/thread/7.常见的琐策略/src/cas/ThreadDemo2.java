package cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/26
 * Time: 17:17
 */
public class ThreadDemo2 {
    /**
     * ABA 问题(正常情况)
     */
    private static AtomicReference money =
            new AtomicReference(100);  // 100 元

    public static void main(String[] args) {
        // 转账: 100 -> 0   A -> B
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一次转账：" +
                        money.weakCompareAndSet(100, 0));
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二次转账：" +
                        money.weakCompareAndSet(100, 0));
            }
        });
        t2.start();
    }

}
