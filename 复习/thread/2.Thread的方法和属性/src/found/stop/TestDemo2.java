package found.stop;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 16:32
 */
public class TestDemo2 {
    /**
     *  使用 interrupt 终止线程
     *      判断线程终止状态：Thread.interrupted()
     *      线程终止：interrupt();
     *      休眠时终止会报异常
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                //while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("正在转账");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
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
