package found;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/6
 * Time: 14:15
 */
public class ThreadPoolDemo3 {
    static int count = 0;

    /**
     * 方式 1：创建固定个数的线程池
     *   ExecutorService service =
     *          Executors.newFixedThreadPool();
     *
     * 线程工厂 ThreadFactory ：设置线程池内线程的属性
     */
    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("myThreadPool-" + count ++ + "  ");
            thread.setPriority(10);
            return thread;
        }
    }
    public static void main(String[] args) {
        // 线程工厂
        MyThreadFactory myThreadFactory = new MyThreadFactory();

        // 创建线程池
        ExecutorService service =
                Executors.newFixedThreadPool(10, myThreadFactory);
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" +
                            Thread.currentThread().getName() + "优先级：" +
                            Thread.currentThread().getPriority());
                }
            });
        }
    }
}
