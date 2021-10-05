package safe.lock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 20:21
 */

public class ThreadDemo11 {
    /**
     * 死锁问题：
     *    多线程编程种（两个或两个以上的线程），因为资源的抢占而造成线程无限等待的问题；
     *
     * 死锁操作的4个条件（同时满足）:
     *   1. 互斥条件：一个资源只能被一个线程持有，当被一个线程拥有之后就不能被其他线程持有
     *   2. 请求拥有条件：一个线程持有了一个资源后，又试图请求另外一个资源
     *   3. 不可剥夺条件： 一个资源被一个线程拥有后，如果这个线程不释放此资源，那么其他线程不能强制获得次资源
     *   4. 环路等待条件： 多个线程在获取资源时形成了一个环形链
     *
     * 如何解决死锁问题
     *   互斥条件不可更改
     *   请求拥有条件可被修改
     *   不可被夺条件不可以修改
     *   环路等待条件 可修改（最容易被改变）
     *      ThreadDemo12 通过控制获取锁的顺序，破坏了环路等待条件
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
                synchronized (lockB) {
                    System.out.println("线程2 获取到了锁B");
                    try {
                        // 休眠 1s,让线程2 先获取到锁 A
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2 等待获取锁A");
                    synchronized (lockA) {
                        System.out.println("线程2 获取到了锁A");
                    }
                }
            }
        }, "t2");
        t2.start();
    }
}
