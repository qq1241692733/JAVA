package thread_0503;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
        内存可见性
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 18:35
 */
public class ThreadSafe2 {
    //private static volatile boolean flag = false;
    private static boolean flag = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag){
                    // 没内容，会将 flag 放到缓存里，导致内存不可见
                    /**
                     变量用 volatile 修饰：
                        解决线程可见性问题
                        禁止指令重回排序
                     实现原理：
                     */
                }
                System.out.println("终止执行");
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
            }
        });
        System.out.println("设置falg == true");
        t2.start();

    }
}
