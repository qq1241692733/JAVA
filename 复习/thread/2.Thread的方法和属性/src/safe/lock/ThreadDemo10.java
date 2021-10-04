package safe.lock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/4
 * Time: 17:13
 */

public class ThreadDemo10 {
    /**
     * 	使用场景：
     * 	 1. 使用 synchronized  来修饰代码块（加锁对象可以自定义）；
     *   2. 使用 synchronized 来修饰静态方法（加锁对象是当前的内对象）；
     * 	 3. 使用 synchronized 来修饰静态方法；
     * 	 4. synchronized 1.6优化 4种状态
     */
    private static int number= 0;

    private static int maxSize= 1000000;

    public synchronized void increment() {
        for (int i = 0; i < maxSize; i++) {
            number++;
        }
    }

    public synchronized void decrement() {
        for (int i = 0; i < maxSize; i++) {
            number--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo10 threadDemo9 = new ThreadDemo10();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadDemo9.increment();
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadDemo9.decrement();
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(number);
    }
}
