package ori;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/8
 * Time: 16:24
 */
public class ThreadPoolDemo4 {
    /**
     * 方式 4：
     *  ThreadPoolExecutor(
     *       int corePoolSize,      核心线程数（正式员工）
     *       int maximumPoolSize,   最大线程数（正式员工和临时工）
     *       long keepAliveTime,    生存周期 （临时工）
     *       TimeUnit unit,         时间单位
     *       BlockingQueue<Runnable> workQueue     任务队列
     *       ThreadFactory threadFactory           线程工厂
     *
     *       RejectedExecutionHandler handler) {   拒绝策略
     *         this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
     *              Executors.defaultThreadFactory(), handler);
     *  )
     *
     * 拒接策略：
     *    例：核心线程数：5    最大线程数：5     任务队列：5
     *     当任务为：11
     *       第一步 11 -5 = 6
     *       第二步： 6 - 5= 1；
     *       第三步： 最大线程数-线程池线程数量 = 0，线程池会执行拒绝策略
     *
     *  );
     */

    public static void main(String[] args) {
        // 默认拒绝策略
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));
        for (int i = 0; i < 11; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务：" + (finalI + 1) + "， 线程名：" +
                            Thread.currentThread().getName());
                }
            });
        }
    }
}
