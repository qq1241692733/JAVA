package thread_0503;

import javax.xml.crypto.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 10:53
 */
public class StartThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程名:" +
                    Thread.currentThread().getName());
        },"张三");
        thread.start();
        thread.run();
    }
}
