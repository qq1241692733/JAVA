import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/9
 * Time: 12:16
 */
public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("状态：" + Thread.currentThread().isInterrupted());
                LockSupport.park();
                System.out.println("状态：" + Thread.currentThread().isInterrupted());
            }
        });
        t1.start();

        Thread.sleep(1000);
        t1.interrupt();
        LockSupport.unpark(t1);
    }
}
