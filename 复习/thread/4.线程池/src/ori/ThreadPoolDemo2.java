package ori;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/7
 * Time: 16:16
 */
public class ThreadPoolDemo2 {
    /**
     * 方式 1：
     *  ThreadPoolExecutor(
     *       int corePoolSize,      核心线程数（正式员工）
     *       int maximumPoolSize,   最大线程数（正式员工和临时工）
     *       long keepAliveTime,    生存周期 （临时工）
     *       TimeUnit unit,         时间单位
     *       BlockingQueue<Runnable> workQueue   任务队列
     *  );
     *
     * 核心线程  ->  任务队列  ->  临时线程
     */
    public static void main(String[] args) {
        // 原始的创建方法
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 10,
                        60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000));
        for (int i = 0; i < 6; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" +
                            Thread.currentThread().getName());
                }
            });
        }
    }
}
