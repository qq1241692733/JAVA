package found.run;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 16:06
 */
public class ThreadDemo1 {
    /**
     * run 和 start 的区别：
          run 属于普通方法，调用了线程任务的方法。而 start 属于启动线程的方法
          run 方法可以执行多次，而 start 方法只能执行一次
     */
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程名：" +
                    Thread.currentThread().getName());
        });
        thread.start();
        thread.run();
    }

}
