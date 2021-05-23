import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
        方式6
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 1:05
 */
public class ThreadPollDemo9 {
    public static void main(String[] args) {
        // 根据当前的工作环(CPU核心数、任务量)异步线程池
        // 同步：按照某种规则，按序执行
        // 同步执行流程： 1. main 调用线程池  2. 线程池执行之后  3. 关闭线程池，main也会随之关闭
        // 异步执行流程： 1. main 调用异步线程池  2. 异步线程池后台执行，对于main线程来说异步线程池已经执行完成，关闭线程池
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i < 100; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名： " + Thread.currentThread().getName());
                }
            });
        }
        // 等待异步线程池执行完成(根据线程池的终止状态进行判断)
        while (!service.isTerminated()) {

        }
    }
}
