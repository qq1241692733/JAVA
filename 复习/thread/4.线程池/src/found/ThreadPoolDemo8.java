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
public class ThreadPoolDemo8 {
    /**
     * 方式 3：创建可以执行定时任务的线程池
     *
     * scheduleWithFixedDelay()  与 scheduleAtFixedRate() 区别 ：
     *   scheduleWithFixedDelay() 是以上次任务 结束时间 作为开始时间
     *   scheduleAtFixedRate() 是以上次任务 开始时间 作为开始时间，适用于稳定的任务处理
     */
    public static void main(String[] args) {
        // 创建可以执行定时任务的线程池
        ScheduledExecutorService service =
                Executors.newScheduledThreadPool(10);
        // 执行任务
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务：" + new Date());
            }
        },0,3,TimeUnit.SECONDS); // 延迟 1s开始执行定时任务，每隔 3s执行一次
    }
}
