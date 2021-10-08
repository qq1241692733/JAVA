package ori;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/8
 * Time: 16:24
 */
public class ThreadPoolDemo3 {
    /**
     * 方式 3：
     *  ThreadPoolExecutor(
     *       int corePoolSize,      核心线程数（正式员工）
     *       int maximumPoolSize,   最大线程数（正式员工和临时工）
     *       long keepAliveTime,    生存周期 （临时工）
     *       TimeUnit unit,         时间单位
     *       BlockingQueue<Runnable> workQueue   任务队列
     *       ThreadFactory threadFactory   线程工厂
     *  );
     */
    private static int count = 1;
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                // r
                Thread t = new Thread(r);
                t.setName("MyThreadPool-" + count++);
                return t;
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),
                threadFactory);
        // 执行任务
        for (int i = 0; i < 5; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
