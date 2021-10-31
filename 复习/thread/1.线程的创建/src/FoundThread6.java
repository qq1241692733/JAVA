import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 17:08
 */
public class FoundThread6 {
    // 实现 Callable
    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int num = new Random().nextInt(10);
            System.out.println("子线程：" + Thread.currentThread().getName() + ",   随机数：" + num);
            return num;
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        // FuntureTask 容器接受返回值  FuntureTask 是 Runnable 的子类
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable() {
            @Override
            public Object call() throws Exception {
                int num = new Random().nextInt(10);
                System.out.println("子线程：" + Thread.currentThread().getName() +
                        ", 随机数：" + num);
                return num;
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();
        int res = futureTask.get();
        System.out.println(String.format("线程名：%s, 线程返回数字： %d", Thread.currentThread().getName(), res));
    }
}
