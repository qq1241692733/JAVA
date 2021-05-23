import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 10:58
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,
                10, 0,TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("编号： " + finalI +
                            "线程名" + Thread.currentThread().getName());
                }
            });
        }
        // 线程关闭
        executor.shutdown();
        //executor.shutdownNow();
    }
}
