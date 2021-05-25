import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
     创建带缓存的线程池
        适合场景： 有大量的短期任务的时候
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 0:17
 */
public class ThreadPoolDemo3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名： " + Thread.currentThread().getName());
                }
            });
        }
    }
}
