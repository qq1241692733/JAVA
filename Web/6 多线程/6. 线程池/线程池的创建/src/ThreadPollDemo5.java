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
public class ThreadPollDemo5 {
    public static void main(String[] args) {
        // 创建定时任务线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        System.out.println("执行任务之前： " + new Date());
        // 执行任务
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务： " + new Date());
            }
        },3, TimeUnit.SECONDS);
        // 无延迟，只执行一次
    }
}
