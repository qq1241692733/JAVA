package found;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/6
 * Time: 19:12
 */
public class ThreadPoolDemo12 {
    /**
     *  演示OOM异常，内存溢出
     *
     *    设置 JVM 最大内存 10MB： -Xmx10m
     *            解释：X(执行) m(内存) x(最大值)：10m
     *      因为 Executors 创建线程池，允许请求队列的长度为 Integer.MAX_VALUE，
     *      会堆积大量的请求导致OOM，内存溢出异常
     *
     *  Executors 创建线程池的问题：
     *      1.线程数量不可控（线程的过度切换和争取，程序执行的比较满）
     *      2.任务数量不可控（任务数量无限大， Integer.MAX_VALUE）
     */

    // 创建一个大对象
    static class MyOOMClass {
        // 1M (B -> KB -> MB)
        private byte[] bytes = new byte[1 * 1024 * 1024];
    }

    public static void main(String[] args) {
        Object[] objects = new Object[15];
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行：" + finalI);
                    MyOOMClass myOOMClass = new MyOOMClass();
                    objects[finalI] = myOOMClass;
                }
            });
        }
    }
}
