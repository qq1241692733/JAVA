package ori;

import java.util.concurrent.LinkedBlockingQueue;
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
public class ThreadPoolDemo8 {
    /**
     * 方式 4：
     *   拒接策略：
     *    拒绝策略种类：（JDK 4 种）
     *
     *      1. new ThreadPoolExecutor.AbortPolicy()
     *              默认拒绝策略
     *      2. new ThreadPoolExecutor.CallerRunsPolicy()
     *              使用调用线程池的线程来执行任务（使用主线程来执行任务）
     *      3. new ThreadPoolExecutor.DiscardOldestPolicy()
     *              忽略新任务
     *      4. new ThreadPoolExecutor.DiscardOldestPolicy()
     *              忽略老任务
     *  );
     */

    public static void main(String[] args) {
        // 忽略老任务
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(5),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        // 忽略最先加入任务队列里的任务： 任务 6
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
