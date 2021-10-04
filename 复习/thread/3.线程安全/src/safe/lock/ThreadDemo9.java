package safe.lock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/4
 * Time: 17:13
 */

public class ThreadDemo9 {
    /**
     * 	使用场景：
     * 	 1. 使用 synchronized 来修饰代码块（加锁对象可以自定义）；
     *   2. 使用 synchronized 来修饰静态方法（加锁对象是当前的内对象）；
     * 	 3. 使用 synchronized 来修饰普通方法；
     * 	 4. synchronized 1.6优化 4种状态
     *
     * 	 volatile 和 synchronized 区别:
     *      volatile 可以解决内存可见性问题和禁止指令重排序，但volatile 不能解决原子性问题；
     *      synchronized 是用来保证线程安全，也就是 synchronized
     *      可以解决任何关于线程安全问题:
     *        1.关键代码排队执行，始终只有一个线程会执行加锁操作；
     *        2.可以解决原子性问题；
     *        3.内存可见性问题；指令重排序问题
     *
     *        ReentrantLock: 可重入锁
     *  synchronized 和 lock 区别：
     *    1.synchronized 即可以修饰代码块，又可以修饰静态方法和普通方法而 lock 只能修饰代码块。
     *    2.synchronized 只有非公平锁的策略，而 lock 既可以是公平锁也可以是非公平锁
     *      （ReentrantLock 默认是非公平锁，也可以通过构造函数设置 true公平锁， false非公平锁）
     *    3.ReentrantLock 更加灵活（比如可以使用 tryLock获取锁，没获取到可以进行其他业务处理）
     *    4.synchronized 是自动加锁和释放锁的，而 ReentrantLock 需要自己加锁和释放锁
     */
    private static int number= 0;

    private static int maxSize= 1000000;

    public static synchronized void increment() {
        for (int i = 0; i < maxSize; i++) {
            number++;
        }
    }

    public static synchronized void decrement() {
        for (int i = 0; i < maxSize; i++) {
            number--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                decrement();
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(number);
    }
}
