import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/26
 * Time: 19:32
 */
public class ThreadDemo1 {
    /**
     * 共享锁 和 非共享锁：
     *   读写锁：
     *      1.读写锁中读锁的共享锁，写锁是非共享锁
     *      2.读锁和写锁的互斥的（防止同时读写锁所产生的脏数据）
     */
    public static void main(String[] args) {
        // 创建一个读写锁
        ReentrantReadWriteLock readWriteLock =
                new ReentrantReadWriteLock();
        // 读锁
        ReentrantReadWriteLock.ReadLock readLock =
                readWriteLock.readLock();
        // 写锁
        ReentrantReadWriteLock.WriteLock writeLock =
                readWriteLock.writeLock();

        // 线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
        0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));
        // 任务1：执行读锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // 加锁
                readLock.lock();
                try {
                    // 业务逻辑处理
                    System.out.println("线程名：" +Thread.currentThread().getName() +
                            "执行了读锁操作：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        });
        // 任务2：执行读锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // 加锁
                readLock.lock();
                try {
                    // 业务逻辑处理
                    System.out.println("线程名：" +Thread.currentThread().getName() +
                            "执行了读锁操作：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }
        });
        // 任务3：执行写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // 加锁
                writeLock.lock();
                try {
                    // 业务逻辑处理
                    System.out.println("线程名：" +Thread.currentThread().getName() +
                            "执行了写锁操作：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        });
        // 任务4：执行写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                // 加锁
                writeLock.lock();
                try {
                    // 业务逻辑处理
                    System.out.println("线程名：" +Thread.currentThread().getName() +
                            "执行了写锁操作：" + new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }
        });
    }
}
