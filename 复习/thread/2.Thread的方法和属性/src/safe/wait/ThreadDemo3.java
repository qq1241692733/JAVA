package safe.wait;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 21:26
 */
public class ThreadDemo3 {
    /**
     * Thread.sleep(0)  和 Object.lock(0) 区别：
     *   1.sleep 它是 Thread 的静态方法； 而 Lock 是 Object 的方法；
     *   2.sleep(0) 立即触发一次 CPU 资源的抢占 lock(0) 永久的等待下去
     */
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1 进入休眠:");
                synchronized (lock) {
                    try {
                        //Thread.sleep(3000);
                        lock.wait(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1 执行完成:");
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

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3 进入休眠");
                synchronized (lock2) {
                    try {
                        lock2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程3 执行完成");
            }
        }, "t3");
        t3.start();

        Thread.sleep(1000);
        System.out.println("主线程唤醒线程");
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
