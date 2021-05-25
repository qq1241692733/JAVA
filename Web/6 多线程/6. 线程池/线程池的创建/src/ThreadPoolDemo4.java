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
public class ThreadPoolDemo4 {
    public static void main(String[] args) {
        // 创建定时任务线程池
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        System.out.println("执行任务之前： " + new Date());
        // 执行任务

         //线程池的任务， 定时任务延迟多长时间开始执行， 定时任务的执行频率， 参数2 和3 的时间单位

        service.scheduleWithFixedDelay(new Runnable() {
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
        // 延迟 1个时间单位开始执行，每隔 3个时间单位执行一次，TimeUnit：时间单位
    }
}
