package thread_0502;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 10:38
 */
public class FoundThread5 {
    /**
     * 创建方法5：
     *    lambda + 匿名 runnable 的实现
     */
    public static void main(String[] args) {
        // lambda + 匿名 runnable 的实现方式
        Thread thread = new Thread(() -> {
            System.out.println("线程名： " +
                    Thread.currentThread().getName());
        });
        thread.start();
    }
}
