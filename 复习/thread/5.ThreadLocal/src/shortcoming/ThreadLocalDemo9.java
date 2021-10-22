package shortcoming;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/14
 * Time: 20:33
 */
public class ThreadLocalDemo9 {
    /**
     *  ThreadLocal 缺点:
     *     3.内存溢出问题（最常出现的问题）
     *
     *         内存溢出：当一个程序执行完后，不会释放这个线程所占内存，或者
     *             释放内存不及时的情况都叫做内存溢出。 线程不用了，但线程相关
     *             的内存还得不到及时的释放
     *
     *     ThreadLocal + 线程池
     *        线程池是长生命周期的
     *         ThreadPool -> Thread -> ThreadLocal -> 内存不会关闭 -> OOM
     *
     *         设置 内存 -Xmx5m
     *
     *         线程8：00:30    00：42理解
     *
     *       线程是长休眠周期的，线程是执行完任务就结束了（线程相关的资源都会释放掉）
     *      为什么将 ThreadLocal 设置成弱引用
     *    ThreadLocal 和 HashMap处理哈希冲突的区别
     *      ThreadLocalMap 开放寻址法处理哈希冲突，hash 之后得到位置i ，然后判断位置是否为空，如果不为空，一直往后找，直到
     *  找到空位置进行插入
     *
     *      HashMap解决哈希冲突的放大：链式法，不为空链表向下找，
     * 	    JDK1.7以后，当链表长度大于8 升级为红黑树，数组的长度大于 64  链表——>红黑树
     * 							当链表的长度小于6，红黑树——>链表
     *
     * 为什么这样设计？
     * 	开放寻址法它的使用特点和使用场景是数据量比较少的情况下性能更好，而 HashMap 里面存储的数据
     * 	通常是比较多的，这个时候使用开放寻址法效率就比较低了，所以使用链式法
     */

    // 1MB
    static class MyBigClass {
        private byte[] bytes = new byte[1 * 1024 * 1024];
    }

    static ThreadLocal<MyBigClass> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    MyBigClass myBigClass = new MyBigClass();
                    System.out.println("任务：" + finalI + "执行了存储方法");
                    threadLocal.set(myBigClass);
                    myBigClass = null;
                }
            });
            t.start();
            Thread.sleep(200);
        }
    }
}
