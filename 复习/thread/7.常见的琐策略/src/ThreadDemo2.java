import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/26
 * Time: 19:54
 */
public class ThreadDemo2 {
    /**
     * 可重入锁：
     */
    private static Object lock = new Object();
    public static void main(String[] args) {
        // 第一次进入锁
        synchronized (lock) {
            System.out.println("第一次进入锁");
            synchronized (lock) {
                System.out.println("第二次进入锁");
            }
        }
    }
}
