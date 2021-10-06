package found;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/6
 * Time: 13:51
 */
public class ThreadPoolDemo1 {
    /**
     * 方式 1：创建固定个数的线程池
     *   ExecutorService service =
     *          Executors.newFixedThreadPool();
     *
     *  经典易错题：
     *      创建了 10个线程来执行 2个任务，问当前程序创建了几个线程？
     *        答： 2个，
     *
     *  线程池的执行流程：
     *      当拿到一个任务之后，会判断当前线程池里边的线程数量是否达到
     *   了最大值，如果没有到达，创建的线程执行任务；
     *      当任务来了后，线程池的线程数量已经是最大值了，并且没有空闲的线程，当前任务会
     *   被放到线程池的任务丢列里边执行等待
     */
    public static void main(String[] args) {
        // D
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行任务
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
