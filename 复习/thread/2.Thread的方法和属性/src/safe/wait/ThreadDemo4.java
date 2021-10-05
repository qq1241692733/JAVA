package safe.wait;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 22:07
 */
public class ThreadDemo4 {
    /**
     * wait 和 sleep 的区别：
     *
     * 相同点：
     *   1.都可以让当前线程休眠
     *    2.都必须要处理一个 Interrupt 异常
     *
     * 不同点：
     *   1.wait 来自于 Object 中的一个方法： 而Sleep 来自于 Thread
     *   2.传参不同，wait可以没有参数，而 Sleep 必须又一个大于0的参数
     *   3.wait 使用必须加锁， sleep 使用时不需要加锁
     *   4.wait 使用时会释放锁，而Sleep 不会释放锁
     *   5.wait 默认不传参的情况下会进入 WAITING 状态， 而Sleep 会进入TIME_WAITING
     *
     * 为什么 wait 会放在 Object 中而不是 Thread？
     *      应为wait 必须加锁和释放锁，而锁又是属于对象级别，而不是线程级别（线程和锁的关系是
     *  一对多的关系，也就是一个线程可以拥有多把锁），为了灵活起见（一个线程当中会有多把锁），就把 wait 放到 Object 中了
     *
     *
     *  证明 wait 释放了锁
     */
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程1 拥有锁 lock, 进入休眠状态");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        Thread.sleep(1000);
        // 主线程试图释放锁
        synchronized (lock) {
            // 因为 wait 释放了锁，所以这里才能获取到锁
            System.out.println("主线程获取到锁 lock");
        }
    }
}
