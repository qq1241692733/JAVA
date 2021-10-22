package question;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/8
 * Time: 20:28
 */
public class ThreadPoolDemo6 {
    /**
     * 1. ThreadLocal 的引入：
     *  需求3：
     *     使用最高效的方法实现 1000个时间格式化
     *
     * 解决线程不安全的问题：
     *   方法1：给加🔒：给 myFormatTime() 方法加锁
     *      缺点：排队执行的性能消耗
     *
     *     怎么既可以解决线程不安全问题，又不用排队，引入 ThreadLocal
     *  方法2：使用后 ThreadLocal
     */
    static SimpleDateFormat dateFormat =
            new SimpleDateFormat("mm:ss");

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000)
        );
        for (int i = 1; i < 1001; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(1000 * finalI);
                    // 打印时间
                    myFormatTime(date);
                }
            });
        }
    }

    /**
     * 自定义时间格式化
     * @param date
     */
    private static synchronized void myFormatTime(Date date) {
        // 优化，改为静态
//        SimpleDateFormat dateFormat =
//                new SimpleDateFormat("mm:ss");
        String res = dateFormat.format(date);
        System.out.println(res);
    }
}
