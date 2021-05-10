import java.util.concurrent.locks.LockSupport;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/9
 * Time: 12:08
 */
public class ThreadDemo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1：进入线程方法");
                LockSupport.park();
                System.out.println("线程1：执行完成");
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2：进入休眠");
                LockSupport.park();
                System.out.println("线程2：执行完成");
            }
        },"t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3：进入休眠");
                LockSupport.park();
                System.out.println("线程3：执行完成");
            }
        },"t3");

        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        System.out.println("唤醒线程");
        LockSupport.unpark(t1);
        Thread.sleep(1000);
        LockSupport.unpark(t2);
        Thread.sleep(1000);
        LockSupport.unpark(t3);
    }
}
