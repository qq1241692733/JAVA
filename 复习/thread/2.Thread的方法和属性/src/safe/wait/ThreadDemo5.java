package safe.wait;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 21:26
 */
public class ThreadDemo5 {
    /**
     * notify() 缺点：
     */
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

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
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程3 执行完成");
            }
        }, "t3");
        t3.start();

        Thread.sleep(100);
        System.out.println("----------------主线程唤醒线程-----------------");
        synchronized (lock) {
            lock.notify();
        }

        Thread.sleep(100);
        synchronized (lock) {
            lock.notify();
        }

        Thread.sleep(100);
        synchronized (lock) {
            lock.notify();
        }
    }
}
