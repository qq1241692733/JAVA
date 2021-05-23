import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
      线程池的创建方式 3：
        可以执行定时任务的线程池
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 0:21
 */
public class ThreadPollDemo6 {
    public static void main(String[] args) {
        // 创建定时任务线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        System.out.println("执行任务之前： " + new Date());
        // 执行任务
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务： " + new Date());
            }
        },1,3, TimeUnit.SECONDS);
        // scheduleWithFixedDelay 以上次任务结束时间为开始时间
        // scheduleAtFixedRate 以上次任务开始时间做起始时间的
    }
}
