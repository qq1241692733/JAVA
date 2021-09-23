/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 16:58
 */
public class FoundThread3 {
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("线程名称：" + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
