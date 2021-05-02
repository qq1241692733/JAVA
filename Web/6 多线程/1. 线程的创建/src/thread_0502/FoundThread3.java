package thread_0502;

import sun.awt.windows.ThemeReader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 10:32
 */
public class FoundThread3 {
    /**
     * 创建方法3：
     *    实现 Runnable 接口的第一种方式
     */
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("线程名： " +
                    Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        //1. 新建 Runnable 类
        MyRunnable runnable = new MyRunnable();
        //2. 新建 Thread
        Thread thread = new Thread(runnable);
        //3. 启动
        thread.start();
    }
}
