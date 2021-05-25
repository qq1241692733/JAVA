import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created with IntelliJ IDEA.
 * Description:
     线程池的创建
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 0:05
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        // 线程工厂
        MyThreadFaction myThreadFaction = new MyThreadFaction();
        // 创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10,myThreadFaction);
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名： " + Thread.currentThread().getName() + ", " +
                            "线程优先级： " + Thread.currentThread().getPriority());
                }
            });
        }
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
