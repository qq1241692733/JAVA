package found;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/6
 * Time: 14:29
 */
public class ThreadPoolDemo4 {
    /**
     * 方式 2：创建带有缓存的线程池
     *    ExecutorService service =
     *          Executors.newCachedThreadPool();
     *  适用场景：有大量的短期任务的时候
     */
    public static void main(String[] args) {
        //创建带有缓存的线程池
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
