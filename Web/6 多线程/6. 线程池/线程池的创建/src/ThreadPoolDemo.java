import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/25
 * Time: 14:43
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service1 = Executors.newFixedThreadPool(10);
        ExecutorService service2 = Executors.newFixedThreadPool(10,new MyThreadFaction());

        ExecutorService service3 = Executors.newCachedThreadPool();

        ScheduledExecutorService service4 = Executors.newScheduledThreadPool(10);
        service4.scheduleWithFixedDelay();
        service4.schedule();
        service4.scheduleAtFixedRate();
        service4.scheduleWithFixedDelay();

        ScheduledExecutorService service5 = Executors.newSingleThreadScheduledExecutor();

        ExecutorService service6 = Executors.newSingleThreadExecutor();

        ExecutorService service7 = Executors.newWorkStealingPool();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,
                0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
    private static int count = 1;
    static class MyThreadFaction implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            //设置线程池的命名
            thread.setName("myThreadPoll-" + count++);
            //设置线程池的优先级
            thread.setPriority(10);
            return thread;
        }
    }
}
