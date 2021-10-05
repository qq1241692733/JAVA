package safe.wait;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 21:26
 */
public class ThreadDemo1 {
    /**
     * sleep 唤醒睡眠
     * 线程通讯机制： 一个线程的动作可以让令一个线程感知到就叫做线程通讯
     *
     * wait(): 查看 wait源码，wait()传参构造方法传参 0
     *
     * wait（休眠）/ notify(唤醒) / notifyAll(唤醒全部)
     *  wait 为什么要加锁?
     *    wait 在释放时候需要释放锁，在释放锁之前必须要又一把锁，所以要加锁
     *
     * 为什么要释放锁？
     *     wait 默认是不传任何值的，当不传递任何值是表示永久等待，这样就会造成一把锁被一个线
     *  程一直持有，为了避免这种问题的方式，所以使用 wait 时一定要
     *
     * Thread.sleep(0)  和 Object.lock(0) 区别：
     *   1.sleep 它是 Thread 的静态方法； 而 Lock 是 Object 的方法；
     *   2.sleep(0) 立即触发一次 CPU 资源的抢占 lock(0) 永久的等待下去
     *
     *
     */
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 进入休眠:" + new Date());
                synchronized (lock) {
                    try {
                        //Thread.sleep(3000);
                        lock.wait(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1 执行完成:" + new Date());
            }
        }, "t1");
        t1.start();

        Thread.sleep(1000);
        System.out.println("主线程唤醒线程t1 " + new Date());
        synchronized (lock) {
            lock.notify();
        }
    }
}
