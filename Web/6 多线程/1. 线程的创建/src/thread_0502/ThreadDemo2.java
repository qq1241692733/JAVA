package thread_0502;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 多线程和单线程的对比
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 9:46
 */
public class ThreadDemo2 {
    //执行次数
    private  static final long count = 1_0000_0000L;

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.currentThread().getName());  //打印此线程名字

        // 调用多线程的方法
        concorrency();

        // 调用单线程执行方法
        serial();
    }

    // 单线程执行时间
    private static void serial() {
        // 开始时间
        long stime = System.currentTimeMillis();  //毫秒
//        System.nanoTime(); //记录当前时间纳秒数
        int a = 0;
        for (int i = 0; i < 3*count; i++) {
            a ++;
        }
        //结束时间
        long etime = System.currentTimeMillis();
        System.out.println("单线程执行时间："+(etime-stime) );
    }

    // 多线程的方法
    private static void concorrency() throws InterruptedException {
        //开始时间
        long stime = System.currentTimeMillis();

        // todo: 3亿次循环
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 具体业务
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a ++;
                }
            }
        });
        //开始执行线程
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i < count; i++) {
                    b ++;
                }
            }
        });
        t2.start();

        // 主线程执行 1亿次
        int c = 0;
        for (int i = 0; i < count; i++) {
            c ++;
        }
        //等待线程 t1和t2 执行完成后，再统计结束时间
        t1.join();
        t2.join();
        // 结束时间
        long etime = System.currentTimeMillis();
        System.out.println("多线程执行时间："+ (etime-stime));
    }
}
