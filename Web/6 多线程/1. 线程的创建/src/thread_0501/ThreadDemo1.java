package thread_0501;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/1
 * Time: 23:24
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        // 常见线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //让程序等待一会
                    Thread.sleep(1000*60*60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 启动线程
        thread.start();
    }
}
