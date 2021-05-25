import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 单个定时任务线程池
      单个线程池的意义：
        1. 无需频繁的创建和销毁
        2. 可以更好的分配和管理以及储存任务
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 0:54
 */
public class ThreadPoolDemo7 {
    public static void main(String[] args) {
        // 创建单个执行任务的线程池
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务： "+ new Date());
            }
        },1,3, TimeUnit.SECONDS);
    }
}
