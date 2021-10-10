package method;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/8
 * Time: 19:17
 */
public class ThreadPoolDemo1 {
    /**
     * 1.
     *  线程池的 2种执行方式:
     *  execute() 和 submit()
     *      1. 使用 execute 只能执行 Runnable 任务，他说无返回值的；
     *      2.  submit 它既能执行 Runnable 任务，也能执行 Callable 有返回值任务
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(100)
        );

        // 返回参数
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int num = new Random().nextInt(10);
                System.out.println("线程池生存了随机数：" + num);
                return num;
            }
        });

        System.out.println("返回值：" + future.get());
        executor.shutdown();
    }
}
