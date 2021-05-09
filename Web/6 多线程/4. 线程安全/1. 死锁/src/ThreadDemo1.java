/**
 * Created with IntelliJ IDEA.
 * Description:
        死锁
 * User: hong yaO
 * Date: 2021-05-2021/5/9
 * Time: 10:04
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程1:获取到锁A");
                    try {
                        // 休眠1S，让线程1先获取到锁A
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1:等待获取锁B");
                    synchronized (lockB) {
                        System.out.println("线程1:获取到了锁A");
                    }
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockB) {
                    System.out.println("线程2:获取到锁B");
                    try {
                        // 休眠1S，让线程1先获取到锁A
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2:等待获取锁A");
                    synchronized (lockA) {
                        System.out.println("线程2:获取到了锁B");
                    }
                }
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
