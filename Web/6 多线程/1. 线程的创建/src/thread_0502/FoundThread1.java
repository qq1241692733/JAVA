package thread_0502;

import javax.sound.midi.Soundbank;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 10:16
 */
public class FoundThread1 {
    /**
     * 创建方法1： 继承 Thread
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            //线程执行任务
            System.out.println("线程名称： "+
                    Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        System.out.println("当前线程名称(主线程)： " +
                Thread.currentThread().getName());
    }
}
