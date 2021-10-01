package found.wait;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/1
 * Time: 14:17
 */
public class TestDemo1 {
    /**
     *    join();  等待线程结束
     *    join(millis);  等待线程结束，最多等 millis 毫秒
     *    public void join(long millis, int nanos);   更高精度
     *
     *    sleep(millis);  休眠线程，休眠 millis 毫秒
     *    sleep(long millis, int nanos);   更高精度
     */
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

        Thread t1 = new Thread(runnable, "张三");
        t1.start();
        // 等待张三
        //t1.join();
        t1.join(900);

        Thread t2 = new Thread(runnable, "李四");
        t2.start();
    }
}
