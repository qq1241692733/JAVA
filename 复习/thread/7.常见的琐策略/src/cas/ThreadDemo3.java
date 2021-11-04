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
public class ThreadDemo3 {
    /**
     * ABA 问题:
     *     小王转账 100元出去，不小心点了两次，此时张三给小王转了 100元
     *  按理说第二次转出应该失败，最后小王账户有 100元
     *
     *      但是在多线程的情况下：就有可能在第一次转出时小王钱转进来了，导致
     *  第二次也转出成功 ，结果最后小王账户里有 0元
     *
     *  ABA问题伪代码
     */
    private static AtomicReference money =
            new AtomicReference(100);  // 100 元

    public static void main(String[] args) throws InterruptedException {
        // 转账: 100 -> 0   A -> B
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一次转账(-100)：" +
                        money.weakCompareAndSet(100, 0));
            }
        });
        t1.start();
        t1.join();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 转入 100
                System.out.println("转入 100元(+100):" +
                        money.compareAndSet(0, 100));
            }
        });
        t3.start();
        t3.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二次转账(-100)：" +
                        money.weakCompareAndSet(100, 0));
            }
        });
        t2.start();
    }
}
