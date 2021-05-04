package thread_0502;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 优先级：
 *      默认 5
 *      取值范围 1 - 10
 *     优先级设置的值越大，优先级就越大，执行的权重就越大
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 0:51
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名：" +
                        Thread.currentThread().getName());
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(runnable,"t1");
            Thread t2 = new Thread(runnable,"t2");
            Thread t3 = new Thread(runnable,"t3");
            // 设置优先级
            t1.setPriority(1);
            t3.setPriority(10);
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
