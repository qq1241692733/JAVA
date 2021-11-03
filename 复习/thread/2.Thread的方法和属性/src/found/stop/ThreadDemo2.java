package found.stop;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 16:32
 */
public class ThreadDemo2 {
    /**
       使用 interrupt 终止线程
           判断线程终止状态：Thread.interrupted()
           线程终止：interrupt();
           休眠时终止会报异常

           当出现终止状态异常时,也会重置为 false
           如果线程调用了 wait/join/sleep 等方法而阻塞挂起，则以 InterruptedException 异常的形式
         通知，清除中断标志
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //while (!Thread.interrupted()) {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        // 当出现终止状态异常时,也会重置为 false
                        break;
                    }
                    System.out.println("正在转账");
                }
                System.out.println("转账完成");
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(310);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("有内鬼，停止交易");
                System.out.println(t1.isInterrupted());
                t1.interrupt();
                System.out.println(t1.isInterrupted());
                System.out.println(t1.isInterrupted());
            }
        });
        t2.start();
        t1.join();
        t2.join();

    }
}
