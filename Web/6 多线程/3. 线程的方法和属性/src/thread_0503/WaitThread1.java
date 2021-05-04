package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 17:04
 */
public class WaitThread1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "上班");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "下班");
            }
        };

        Thread t1 = new Thread(runnable,"张三");
        t1.start();
        t1.join();  // 等待张三拿下班
        //t1.join(1000);
        Thread t2 = new Thread(runnable,"李四");
        t2.start();

    }
}
