import javax.crypto.spec.PSource;

/**
 * Created with IntelliJ IDEA.
 * Description:
    对比单线程和多线程 1000w 次循环使用的时间
    欣慰多线程本身所占用资源开销，所以 3个线程所花费的时间大于 单个线程花费时间是 1/3 倍
 * User: hong yaO
 * Date: 2021-09-2021/9/21
 * Time: 15:06
 */
public class ThreadDemo2 {
    private static final Long count = 100_000_000L;
    public static void main(String[] args) throws InterruptedException {
        // 对比单线程和多线程 1000w 次循环使用的时间
        concorrency();
        serial();
    }

    // 单线程的方法
    private static void serial() {
        Long sTime = System.currentTimeMillis();
        //System.nanoTime();// ns
        int a = 0;
        for (int i = 0; i < count * 3; i++) {
            a++;
        }
        Long eTime = System.currentTimeMillis();
        System.out.println("单线程运行时间：" + (eTime - sTime));
    }

    // 多线程的方法
    private static void concorrency() throws InterruptedException {
        Long sTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a++;
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i < count; i++) {
                    b++;
                }
            }
        });
        t2.start();

        // 主线程执行
        int c = 0;
        for (int i = 0; i < count; i++) {
            c ++;
        }
        t1.join();
        t2.join();

        Long eTime = System.currentTimeMillis();
        System.out.println("多线程执行时间：" + (eTime - sTime));
    }
}
