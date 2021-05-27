package aba;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created with IntelliJ IDEA.
 * Description:
        解决 ABA问题
 * User: hong yaO
 * Date: 2021-05-2021/5/27
 * Time: 19:50
 */
//class 我 {
//    String name;
//    我(String name) {
//        this.name = name;
//    }
//}
public class ThreadDemo3 {

    // 有100
    private static AtomicStampedReference money =
            new AtomicStampedReference(100,1);  //(初值，版本号)
    public static void main(String[] args) throws InterruptedException {
//        我 马牛逼 = new 我("马牛逼");
//        System.out.println(马牛逼.name);

        // 第一次点转出100
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean re = money.compareAndSet(100,0,1,2);
                System.out.println(re);
            }
        });
        t1.start();
        t1.join();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                // +100;
                boolean re = money.compareAndSet(0,100,2,3);
                System.out.println(re);
            }
        });
        t3.start();
        t3.join();

        // 第二次点转出100
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean re = money.compareAndSet(100,0,1,2);
                System.out.println(re);
            }
        });
        t2.start();
        t3.join();
    }
}
