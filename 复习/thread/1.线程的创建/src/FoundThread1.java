/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/21
 * Time: 15:00
 */
public class FoundThread1 {
    //方法1： 继承Thread
    static class MyThread extends Thread {
        @Override
        public void run() {
            // 线程执行任务
            System.out.println("线程名称:" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        System.out.println("当前线程名称（主线程）:" + Thread.currentThread().getName());
    }


}
