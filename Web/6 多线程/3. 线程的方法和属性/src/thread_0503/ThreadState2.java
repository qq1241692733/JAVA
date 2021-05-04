package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 17:57
 */
public class ThreadState2 {
    private static final int maxSize = 1000;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < maxSize; i++) {
                Thread.yield();  //出让 CPU 执行权
                System.out.println("t1");
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < maxSize; i++) {
                System.out.println("t2");
            }
        },"t2");
        t2.start();
    }
}
