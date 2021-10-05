package safe.lock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/4
 * Time: 17:13
 */

public class ThreadDemo5 {
    /**
     * 解决线程安全问题：
     *   1.CPU 抢占性执行（不能解决）
     *   2.每个线程操作自己的变量（可能）不通用，修改难度大
     *   3.在关键代码绕过所有的CPU排队执行，加锁
     *      关键步骤：
     * 	        1.尝试获取锁 （如果成功拿到锁，排队等待）
     * 	        2.释放锁
     *
     * Java 中解决线程安全方案：
     *   1.synchronized 加锁和释放锁（JVM 层面的解决方案，会自动进行加锁和释放锁）
     *     注意：同一组业务一定要同一把🔒
     *
     *     	实现原理：
     * 		1. 操作系统： 互斥锁 mutex
     * 		2. JVM： 帮我们实现的监视器锁的加锁和释放锁的操作
     * 		3. Java：
     * 				锁对象 mutex
     * 				锁存的地方： 变量的对象头
     * 		synchronized JDK 6 之前使用重量级锁实现，性能低，比常用
     * 		JDK 6对 synchronized 做了一个优化（）
     *          无锁 --(第一次访问) 升级--> 偏向锁 --自旋：while(true) {尝试获取锁} 升级-->
     *          轻量级锁 --一段时间还未获取到锁：停止自旋，并把当前没有获取到锁的线程放到等待队列里边 升级--> 重量级锁
     *          视频：线程(3)，1:49:00 左右
     *
     *      重点查看：
     *        查看课件：多线程-初阶
     *        博客：https://www.jianshu.com/p/19f861ab749e
     *        视频：线程(3)，1:20:00 左右
     *
     *   2.Lock 手动🔒（程序员需要自己进行加锁和释放锁）
     *      只能用来修饰代码块
     */
    private static int number= 0;
    private static int maxSize= 1000000;
    public static void main(String[] args) throws InterruptedException {
        // 创建🔒
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    synchronized (lock) {
                        number++;
                    }
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    synchronized (lock) {
                        number--;
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
