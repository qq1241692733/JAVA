package thread_0505;

/**
 * Created with IntelliJ IDEA.
 * Description:
        volatile 不能解决非原子性问题
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 18:07
 */
public class ThreadSafe3 {
   private static int number = 0;
   //最大长度
   private static final int maxSize = 100000;
    public static void main(String[] args) throws InterruptedException {
        // 创建一个 🔒 对象   同一组业务一定要同一把🔒
        Object lock1 = new Object();
        //Object lock2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    synchronized (lock1){
                        number ++;
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    synchronized (lock1){
                        number --;
                    }
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println(number);
    }
}

