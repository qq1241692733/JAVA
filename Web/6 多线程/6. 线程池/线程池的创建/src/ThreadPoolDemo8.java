import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 1:02
 */
public class ThreadPoolDemo8 {
    public static void main(String[] args) {
        // 创建单个线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            // 执行任务
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名: "+ Thread.currentThread().getName());
                }
            });
        }
    }
}
