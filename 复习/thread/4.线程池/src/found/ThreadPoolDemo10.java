package found;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/6
 * Time: 18:39
 */
public class ThreadPoolDemo10 {
    /**
     * 方式 5:创建单个线程的线程池
     */
    public static void main(String[] args) {
        // 创建单个线程的线程池
        ExecutorService service =  Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(finalI + "线程名：" +
                            Thread.currentThread().getName());
                }
            });
        }
    }
}
