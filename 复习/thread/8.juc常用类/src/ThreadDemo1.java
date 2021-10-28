import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/28
 * Time: 14:48
 */
public class ThreadDemo1 {
    /**
     * 信号量：Semaphore
     */
    public static void main(String[] args) {
        // 创建信号量
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 10, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 到达停车厂");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 试图进入停车场
                    try {
                        // 尝试获取锁
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " 进入停车厂");
                        int num = 1 + new Random().nextInt(4);
                        try {
                            Thread.sleep(num * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // 离开停车场
                        System.out.println(Thread.currentThread().getName() + " 离开停车厂");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // 释放锁
                        semaphore.release();
                    }
                }
            });
        }

    }
}
