/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/9
 * Time: 11:10
 */
public class ThreadDemo4 {
    public static void main(String[] args) throws InterruptedException {
        Object lock  = new Object();
        Object lock2  = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程1：进入线程方法");
                    try {
                        lock.wait();  // 不传默认为0，表示永久等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1：执行完成");
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2：进入休眠");
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程2：执行完成");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3：进入休眠");
                synchronized (lock2) {
                    try {
                        lock2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程3：执行完成");
            }
        });

        t1.start();
        t2.start();
        t3.start();

        System.out.println("唤醒线程");
        Thread.sleep(1000);
        synchronized (lock) {
            lock.notifyAll();
        }
        Thread.sleep(1000);
        synchronized (lock2) {
            lock2.notifyAll();
        }
    }
}
