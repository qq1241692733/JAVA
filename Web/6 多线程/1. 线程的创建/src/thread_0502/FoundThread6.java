package thread_0502;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 10:46
 */
public class FoundThread6 {
    /**
     * 创建方法6：
     *     实现 Callable 接口 + Future 的方式
     *     可以得到线程的执行结果
     */
    // 创建了线程的任务和返回方法
    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int num = new Random().nextInt(10);
            System.out.println("子线程：" + Thread.currentThread().getName() +
                    ", 随机数：" + num);
            return num;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.创建一个Callable
        MyCallable myCallable = new MyCallable();
        // 2.创建一个 FutureTask 对象来接受返回值
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        // 3. 创建 Thread
        Thread thread = new Thread(futureTask,"我创建的线程");  //futureTask 是 runnable的子类
        thread.start();
        // 得到线程执行结果
        int result = futureTask.get();
        System.out.println(String.format("线程名：%s, 数字：%d",
                Thread.currentThread().getName(),result));
    }
}
