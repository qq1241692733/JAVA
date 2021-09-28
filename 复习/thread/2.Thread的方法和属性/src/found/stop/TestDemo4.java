package found.stop;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 16:41
 */
public class TestDemo4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (Thread.interrupted()) {
                        System.out.println("开机自动下载，剩余时间 2s");
                        try {
                            Thread.sleep(4000);
                            //Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("下载完成");
                    }
                }
            }
        });
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开机，3s后自动关机");
                //System.out.println(t1.isInterrupted());
                System.out.println(t1.getState());
                t1.interrupt();

                // 开机 3s 自动关机
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(t1.isInterrupted());
                System.out.println(t1.getState());
                // Thread.State s = t1.getState();
                if (t1.getState().name().equals("TIMED_WAITING")) {
                    System.out.println("未下载完");
                }
                System.out.println("关机");
            }
        });
        t2.start();
    }
}
