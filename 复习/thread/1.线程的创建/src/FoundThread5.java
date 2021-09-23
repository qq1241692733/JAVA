/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 17:06
 */
public class FoundThread5 {
    public static void main(String[] args) {
        // lambda(jdk 1.8) + 匿名 runnable 的实现
        Thread thread = new Thread(() -> {
            System.out.println("线程名称：" + Thread.currentThread().getName());
        });
        thread.start();
    }
}
