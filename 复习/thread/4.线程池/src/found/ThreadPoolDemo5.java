package found;

import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;
import java.util.concurrent.ExecutorService;
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
public class ThreadPoolDemo5 {
    /**
     * 方式 3：创建可以执行定时任务的线程池 1
     *        ScheduledExecutorService service =
     *            Executors.newScheduledThreadPool();
     *
     * 1.scheduleWithFixedDelay() 参数：
     *   scheduleWithFixedDelay(
     *          Runnable command,        线程池内的线程任务
     *          long initialDelay,       定时任务延时多久开始执行
     *          long delay,              定时任务的执行时间间隔
     *          TimeUnit unit            参数2 和参数3 的时间单位
     *          )
     *
     */
    public static void main(String[] args) {
        // 创建可以执行定时任务的线程池
        ScheduledExecutorService service =
                Executors.newScheduledThreadPool(10);
        System.out.println("执行任务前：" + new Date());
        // 执行任务
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务：" + new Date());
            }
        },1,3,TimeUnit.SECONDS); // 延迟 1s开始执行定时任务，每隔 3s执行一次
    }
}
