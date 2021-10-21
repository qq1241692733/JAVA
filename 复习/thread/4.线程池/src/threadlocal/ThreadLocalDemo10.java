package threadlocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/14
 * Time: 20:33
 */
public class ThreadLocalDemo10 {
    /**
     *  ThreadLocal 缺点:
     *     3.内存溢出问题（最常出现的问题）
     *
     *         内存溢出：当一个程序执行完后，不会释放这个线程所占内存，或者
     *             释放内存不及时的情况都叫做内存溢出。 线程不用了，但线程相关
     *             的内存还得不到及时的释放
     *
     *     ThreadLocal + 线程池
     *        线程池是长生命周期的
     *         ThreadPool -> Thread -> ThreadLocal -> 内存不会关闭 -> OOM
     */

    // 1MB
    static class MyBigClass {
        private byte[] bytes = new byte[1 * 1024 * 1024];
    }

    static ThreadLocal<MyBigClass> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, 10, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("编号：" + finalI + "执行了存储方法");
                    MyBigClass myBigClass = new MyBigClass();
                    threadLocal.set(myBigClass);
                    myBigClass = null;
                }
            });
            Thread.sleep(200);
        }
    }
}
