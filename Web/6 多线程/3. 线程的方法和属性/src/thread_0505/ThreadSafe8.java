package thread_0505;

import thread_0503.ThreadSafe;

/**
 * Created with IntelliJ IDEA.
 * Description:
       synchronized 修饰静态方法
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 18:07
 */
public class ThreadSafe8 {
   private static int number = 0;
   //最大长度
   private static final int maxSize = 100000;

   private synchronized void increment() {
       for (int i = 0; i < maxSize; i++) {
           number ++;
       }
   }
    private synchronized void decrement() {
        for (int i = 0; i < maxSize; i++) {
            number --;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafe8 threadSafe8 = new ThreadSafe8();
        Object lock1 = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafe8.increment();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafe8.decrement();
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(number);
    }
}

