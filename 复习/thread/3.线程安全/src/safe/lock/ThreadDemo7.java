package safe.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/4
 * Time: 18:58
 */
public class ThreadDemo7 {
    /**
     *  分别把 加锁放到 try 里边和 try 外边，运行查看报错信息
     */
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        // 1.放到外边
        lock.lock();
        try {
            int num = 1/0;
            // 2.放到里边
            //lock.lock();
        } finally {
            lock.unlock();
        }
    }
}
