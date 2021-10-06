package found;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/6
 * Time: 17:58
 */
public class ThreadPoolDemo9 {
    /**
     * 方式 4：创建单个执行定时任务的线程池
     *         ScheduledExecutorService service =
     *                 Executors.newSingleThreadScheduledExecutor();
     *
     *  单个线程的线程池有什么意义？
     *      1.无需频繁的创建和销毁线程
     *      2.因为线程池有任务队列，可以更好的分配和管理以及存储任务
     */
    public static void main(String[] args) {
        // 创建单个执行定时任务的线程池
        ScheduledExecutorService service =
                Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务" + new Date());
            }
        }, 0, 3, TimeUnit.SECONDS);
    }
}
