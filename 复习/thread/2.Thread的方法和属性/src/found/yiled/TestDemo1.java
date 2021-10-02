package found.yiled;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/2
 * Time: 11:41
 */
public class TestDemo1 {
    /**
     * yiled() 出让 CPU 执行权，特点不一定能正常出让 cpu 的执行劝
     */

    private static final int maxSize = 1000;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    Thread.yield();
                    System.out.println("我是t1");
                }
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    System.out.println("我是t2");
                }
            }
        }, "t2");
        t2.start();
    }
}
