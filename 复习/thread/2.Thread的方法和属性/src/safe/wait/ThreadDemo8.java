package safe.wait;

import java.util.Date;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 22:52
 */
public class ThreadDemo8 {
    /**
     *  parkUntil 传参注意事项
     */
    public static void main(String[] args) throws InterruptedException {
        int[] a = new int[100];

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 进入休眠 " + new Date());
                LockSupport.parkUntil(2000);
                System.out.println("t1 终止休眠 " + new Date());
            }
        });
        t1.start();
        t1.join();

        System.out.println("--------------");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2 进入休眠 " + new Date());
                LockSupport.parkUntil(System.currentTimeMillis() + 2000);
                System.out.println("t2 终止休眠 " + new Date());
            }
        });
        t2.start();

    }
}
