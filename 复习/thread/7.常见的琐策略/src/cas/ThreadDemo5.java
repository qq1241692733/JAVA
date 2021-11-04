package cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/26
 * Time: 17:17
 */
public class ThreadDemo5 {
    /**
     * ABA 问题的解决办法:
     *      AtomicReference -> AtomicStampedReference
     *      initialStamp: 版本号
     *
     *      Integer 高速缓存  -128 - 127
     */
//    private static AtomicReference money =
//            new AtomicReference(100);  // 100 元
    private static AtomicStampedReference money =
            new AtomicStampedReference(1000, 0);

    public static void main(String[] args) throws InterruptedException {
        // 转账: 100 -> 0   A -> B
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一次转账(-100)：" +
                        money.weakCompareAndSet(1000, 0,
                                0,1));
            }
        });
        t1.start();
        t1.join();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 转入 100
                System.out.println("转入 100元(+100):" +
                        money.compareAndSet(0, 1000,
                                1,2));
            }
        });
        t3.start();
        t3.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二次转账(-100)：" +
                        money.weakCompareAndSet(1000, 0,
                                0,1));
            }
        });
        t2.start();
    }
}
