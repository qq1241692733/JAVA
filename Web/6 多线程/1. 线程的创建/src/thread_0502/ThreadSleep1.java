package thread_0502;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 线程休眠
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 11:15
 */
public class ThreadSleep1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始时间：" +
                new Date());
        // 休眠 方式1：
        Thread.sleep(1000);
        System.out.println("结束时间：" +
                new Date());
        // 方式2：
        TimeUnit.SECONDS.sleep(1);
        System.out.println("结束时间：" +
                new Date());
        // 方式3：
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("结束时间：" +
                new Date());
    }
}
