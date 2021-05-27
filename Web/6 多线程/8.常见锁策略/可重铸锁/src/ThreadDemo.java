/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/27
 * Time: 21:07
 */
public class ThreadDemo {
    private static Object lock = new Object();

    public static void main(String[] args) {
        synchronized (lock) {
            System.out.println("第一次进入");
            synchronized (lock) {
                System.out.println("第二次进入");
            }
        }
    }
}
