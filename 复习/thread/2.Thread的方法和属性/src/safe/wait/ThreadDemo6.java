package safe.wait;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 21:26
 */
public class ThreadDemo6 {
    /**
     * wait 和 LockSupport 区别：
     *   相同点：
     *       1. 两个都可以进行休眠
     *       2. 二者都可以传参或者不传参，并且二者线程状态也是不一致的
     *
     *   不同点：
     *       3. wait 必须配合 synchronized 一起使用（必须加锁），而 LockSupport 不许加锁
     *       4. wait 只能唤醒全部和随机的一个线程，而 LockSupport 可以换新号任意线程
     *
     * 演化过程：  sleep -->  wait /notify /notifyAll --> LockSupport
     *
     */
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 进入休眠:");
                // 线程休眠
                LockSupport.park();
                System.out.println("线程1 执行完成:");
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2 进入休眠");
                LockSupport.park();
                System.out.println("线程2 执行完成");
            }
        }, "t2");
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3 进入休眠");
                LockSupport.park();
                System.out.println("线程3 执行完成");
            }
        }, "t3");
        t3.start();

        Thread.sleep(1000);
        System.out.println("----唤醒线程----");

        Thread.sleep(100);
        LockSupport.unpark(t3);

        Thread.sleep(100);
        LockSupport.unpark(t2);

        Thread.sleep(100);
        LockSupport.unpark(t1);

    }
}
