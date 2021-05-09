/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/9
 * Time: 11:46
 */
public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
//        Object lock1 = new Object();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (lock1) {
//                    System.out.println("线程1： 拥有了锁lock1，进入休眠状态");
//                    try {
//                        lock1.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//        t1.start();
//
//        Thread.sleep(1000);
//        // 主线程试图获取锁
//        synchronized (lock1) {
//            System.out.println("主线程获取到锁 lock1");
//        }

        Object lock2 = new Object();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("线程2： 拥有了锁lock2，进入休眠状态");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();

        Thread.sleep(1000);
        // 主线程试图获取锁
        synchronized (lock2) {
            System.out.println("主线程获取到锁 lock2");
        }
    }
}
