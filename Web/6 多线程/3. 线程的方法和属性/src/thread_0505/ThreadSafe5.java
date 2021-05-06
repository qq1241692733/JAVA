package thread_0505;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/5
 * Time: 21:28
 */
public class ThreadSafe5 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        /**
         * 如果将 lock（） 方法放在 try 里，那么当try里边的代码出现
         * 异常后就会执行 finally 里的释放锁，但这个时候加锁还没成功
         *如果将lock（） 方法放在 try 里，那么执行 finally 里释放锁代码
         * 时就会报错，线程状态已成，释放锁的异常会覆盖掉业务代码的异常报错
         */
        lock.lock();
        try{
            int num = 1/0;
           // lock.lock();
        }finally {
            lock.unlock();
        }
    }
}
