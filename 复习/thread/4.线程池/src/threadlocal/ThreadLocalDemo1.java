package threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.logging.SimpleFormatter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/13
 * Time: 20:25
 */
public class ThreadLocalDemo1 {
    /**
     *  ThreadLocal 实战：
     *   1. 解决：使用最高效的方法实现 1000个时间格式化
     */

    static ThreadLocal<SimpleDateFormat> threadLocal =
//            ThreadLocal.withInitial(() ->
//                    new SimpleDateFormat("mm:ss"));
            ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
                @Override
                public SimpleDateFormat get() {
                    System.out.println("————————————执行了初始化方法———————————");
                    return new SimpleDateFormat("mm:ss");
                }
            });
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
        10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(finalI * 1000);
                    myFormat(date);
                    if(finalI == 999) {
                        threadLocal.remove();
                    }
                }
            });
        }
    }

    public static void myFormat(Date date) {
        String result = threadLocal.get().format(date);
        System.out.println("时间：" + result);
    }
}
