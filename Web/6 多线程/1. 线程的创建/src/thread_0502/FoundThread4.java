package thread_0502;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 10:36
 */
public class FoundThread4 {
    /**
     * 创建方法4：
     *    实现 Runnable 接口的第二种方式
     */
    public static void main(String[] args) {
        // 匿名内部类的方式实现线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名： " +
                        Thread.currentThread().getName());
            }
        });
        thread.start();
    }
}
