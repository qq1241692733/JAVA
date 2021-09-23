package found;

/**
 * Created with IntelliJ IDEA.
 * Description:
    Thread 构造方法
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 17:54
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名称：" + Thread.currentThread().getName());
            }
        };
        Thread t1 = new Thread(runnable, "张三");
        Thread t2 = new Thread(runnable, "李四");
        t1.start();
        t2.start();
    }
}
