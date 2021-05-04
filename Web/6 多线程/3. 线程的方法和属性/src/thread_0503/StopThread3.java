package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 11:24
 */
public class StopThread3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    //while (!Thread.currentThread().isInterrupted())
                    //Thread.interrupted() 会产生复位
                    System.out.println("正在转账");
                }
                System.out.println("终止转账");
            }
        });
        t1.start();
        Thread.sleep(10);
        t1.interrupt();
    }
}
