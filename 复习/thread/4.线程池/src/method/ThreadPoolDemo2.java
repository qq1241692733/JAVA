package method;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/8
 * Time: 20:04
 */
public class ThreadPoolDemo2 {
    /**
     * 2. 线程池的关闭：
     *   shutdown() 和 shutdownNow() 的区别：
     *     shutdown()： 拒绝执行新任务加入，等待线程池中的任务队列执行完之后，再停止线程池
     *     shutdownNow()： 拒绝执行新任务，不会等待任务队列中的任务执行完成，就会停止线程池
     */
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
        10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100)
        );
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format("标号：%d, 线程名:%s",
                            finalI,Thread.currentThread().getName()));
                }
            });
        }
        //executor.shutdown();
        executor.shutdownNow();
    }
}
