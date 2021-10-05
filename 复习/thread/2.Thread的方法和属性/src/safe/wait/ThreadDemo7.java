package safe.wait;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/5
 * Time: 22:34
 */
public class ThreadDemo7 {
    /**
     * LockSupport 不用处理 interrupt异常，但能正常感知到
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("休眠之前 Interrupt 状态：" +
                        Thread.currentThread().isInterrupted());
                LockSupport.park();
                System.out.println("休眠之前 Interrupt 状态：" +
                        Thread.currentThread().isInterrupted());
            }
        });
        t1.start();

        Thread.sleep(1000);

        // 终止线程
        t1.interrupt();

        LockSupport.unpark(t1);
    }
}
