package safe.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/4
 * Time: 18:38
 */

public class ThreadDemo6 {
    /**
     * JUC就是java.util .concurrent工具包的简称。这是一个处理线程的工具包,JDK 1.5开始出现的
     * Locke 手动锁：
     *    注意事项：一定把 Lock 写在 try 外边
     *       原因： 1.如果放到 try里边，当try里变的代码出现问题之后那么就会执行 finally 里的
     *          释放锁代码，但是这个时候还没加锁成功
     *             2.如果将 lock() 方法放在 try 里边，那么当执行 finally 里边的释放锁代码的
     *             时候就会鲍旭哦（线程状态异常），释放锁的异常回覆盖掉业务代码的异常报错，从而增
     *             加了排除错误的成本 ThreadDemo7 里有示例
     *
     *    灵活，再获取锁失败后可以写自己的业务处理方法，而synchronized 只能死等
     */
    private static int number= 0;
    private static int maxSize= 1000000;
    public static void main(String[] args) throws InterruptedException {
        // 创建 手动🔒
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    //加锁,lock 写在 try 外边
                    lock.lock();
                    try {
                        number++;
                    } finally {
                        // 解锁
                        lock.unlock();
                    }
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    lock.lock();
                    try {
                        number--;
                    } finally {
                        // 解锁
                        lock.unlock();
                    }
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(number);
    }
}
