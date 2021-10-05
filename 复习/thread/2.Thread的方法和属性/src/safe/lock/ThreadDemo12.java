package safe.lock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 21:05
 */
public class ThreadDemo12 {
    /**
     *  解决死锁问题：
     *      通过控制获取锁的顺序，破坏了环路等待条件
     */
    public static void main(String[] args) {
        // 锁A（资源A）
        Object lockA = new Object();
        // 锁B（资源B）
        Object lockB = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程1 得到了锁A");
                    try {
                        // 休眠 1s,让线程 2 先获取的锁 B
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1 等待获取锁B");
                    synchronized (lockB) {
                        System.out.println("线程1 得到了锁B");
                    }
                }
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程2 获取到了锁A");
                    try {
                        // 休眠 1s,让线程2 先获取到锁 A
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2 等待获取锁B");
                    synchronized (lockB) {
                        System.out.println("线程2 获取到了锁B");
                    }
                }
            }
        }, "t2");
        t2.start();
    }
}
