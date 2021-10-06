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
 * Time: 14:37
 */
public class ThreadPoolDemo6 {
    /**
     * 方式 3：创建可以执行定时任务的线程池 3
     *        ScheduledExecutorService service =
     *            Executors.newScheduledThreadPool();
     *
     * 2.schedule() 参数：
     *  schedule(
     *      Runnable command,
     *      long delay,
     *      TimeUnit unit
     *      ) 区别:
     *          1.无延时执行时间
     *          2.只执行一次
     *
     */
    public static void main(String[] args) {
        // 创建可以执行定时任务的线程池
        ScheduledExecutorService service =
                Executors.newScheduledThreadPool(10);
        System.out.println("执行任务前：" + new Date());
        // 执行任务
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务：" + new Date());
            }
        },3,TimeUnit.SECONDS); // 3s 后执行一次
    }
}
