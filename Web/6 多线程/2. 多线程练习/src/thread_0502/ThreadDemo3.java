package thread_0502;

import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/8
 * Time: 18:55
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String string = "ADCD";
                for (char item : string.toCharArray()) {
                    System.out.print(item);
                }
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.start();
    }
}
