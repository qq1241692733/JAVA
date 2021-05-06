package thread_0505;

/**
 * Created with IntelliJ IDEA.
 * Description:
       synchronized 修饰静态方法
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 18:07
 */
public class ThreadSafe7 {
   private static int number = 0;
   //最大长度
   private static final int maxSize = 100000;

   private static synchronized void increment() {
       for (int i = 0; i < maxSize; i++) {
           number ++;
       }
   }
    private static synchronized void decrement() {
        for (int i = 0; i < maxSize; i++) {
            number --;
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

