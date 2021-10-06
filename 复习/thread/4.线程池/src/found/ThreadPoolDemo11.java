package found;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/6
 * Time: 18:45
 */
public class ThreadPoolDemo11 {
    /**
     * 方式6（JDK 1.8+）:
     *      根据当前的工作环境(cup核心数，任务量)创建线程，异步线程池
     *    synchronized: 同步，按照某种规则按续执行就叫同步
     *
     *    同步执行流程：
     *      1.main 调用线程池
     *      2.线程池执行之后
     *      3.关闭线程池，main 也会随之关闭
     *
     *    异步执行流程：
     *      1.main 调用异步线程池
     *      2.异步线程池后台执行，对于 main 线程来说线程池已经执行完成，关系 Main 线程
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" +
                            Thread.currentThread().getName());
                }
            });
        }

        // 等待异步线程池执行完（根据线程池的线程状态）
        while (!service.isTerminated()) {

        }
    }
}
