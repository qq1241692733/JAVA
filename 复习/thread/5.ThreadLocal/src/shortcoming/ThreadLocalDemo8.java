package shortcoming;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/14
 * Time: 19:54
 */
public class ThreadLocalDemo8 {
    /**
     *  ThreadLocal 缺点:
     *    2.脏读
     *      在一个线程中读取到了不属于自己的数据
     *
     *     线程使用 ThreadLocal 不会出现脏读，因为每个线程使用的都是自己的变量值
     *   和ThreadLocal。 如果在 线程池里输赢ThreadLocal 就会出现脏读，线程会复
     *   用线程，复用之后也会复用线程中的静态方法，从而导致某些方法不能被执行，便出现了脏读
     *
     *   解决方案：
     *      1.避免使用静态属性，因为静态属性在线程池中会复用
     *      2.remove
     */
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
        1, 1, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        for (int i = 0; i < 2; i++) {
            MyTask t1 = new MyTask();
            executor.execute(t1);
        }
    }

    static class MyTask extends Thread {
        // 标识是否第一次访问
        static boolean isFirst = true;

        @Override
        public void run() {
            if (isFirst) {
                // 第一次访问，存储用户信息
                threadLocal.set(this.getName() + "session info");
                isFirst = false;
            }
            try {
                String result = threadLocal.get();
                System.out.println(this.getName() +
                        ": " + result);
            } finally {
                threadLocal.remove();
            }

        }
    }
}
