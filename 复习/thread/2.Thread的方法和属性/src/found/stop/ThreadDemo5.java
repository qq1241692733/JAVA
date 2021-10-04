package found.stop;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 20:05
 */
public class ThreadDemo5 {
    private static boolean flag = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (Thread.currentThread().isInterrupted()) {
                        //while (!Thread.currentThread().isInterrupted()) {
                        System.out.println("正在转账");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                        //System.out.println(Thread.currentThread().isInterrupted());
                    }
                    if (Thread.currentThread().isInterrupted()) break;
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
                t1.interrupt();
            }
        });
        t2.start();
    }
}
