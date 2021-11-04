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
public class ThreadDemo2 {
    /**
     * Thread.sleep(0)  和 Object.lock(0) 区别：
     *   1.sleep 它是 Thread 的静态方法； 而 Lock 是 Object 的方法；
     *   2.sleep(0) 立即触发一次 CPU 资源的抢占 lock(0) 永久的等待下去
     *
     * wait /notify / notifyAll使用注意事项:
     *  1.在使用以上方法的时候必须要加锁。
     *  2.加锁对象和 wait /notify /notifyAll 的对象必须保持一致。
     *  3.一组 wait 和 notfiy/ notfiyAll 必须是同一对象。
     *  4.notifyAll 只能唤醒当前对象的所有等待线程。
     */
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 进入休眠");
                synchronized (lock) {
                    try {
                        /**
                         *  sleep 和 wait 区别
                         */
                        //Thread.sleep(3000);
                        lock.wait(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1 执行完成");
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2 进入休眠");
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程2 执行完成");
            }
        }, "t2");
        t2.start();

        Thread.sleep(1000);
        System.out.println("主线程唤醒线程");
        synchronized (lock) {
            lock.notify();
            //lock.notifyAll();
        }
    }
}
