import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 17:21
 */
public class ThreadSleep1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始时间：" + new Date());
        //System.out.println(TimeUnit.MINUTES.toMillis(1));
        Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(1);
//        TimeUnit.DAYS.sleep(1);
//        TimeUnit.HOURS.sleep(24);
        Thread.sleep(TimeUnit.MINUTES.toMillis(1)); // 1 min换成ms
        System.out.println("介绍时间：" + new Date());
    }
}
