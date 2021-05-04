package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
      使用全局自定义的变量来终止线程
    拿到终止指令后，需要执行完当前任务才会终止
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 11:03
 */
public class StopThread1 {
    private static boolean flag = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("正在转账");
                }
                System.out.println("终止转账");
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
                System.out.println("停止交易，有内鬼");
                flag = true;
            }
        });
        t2.start();
    }
}
