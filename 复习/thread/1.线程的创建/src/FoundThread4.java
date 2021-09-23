/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 17:03
 */
public class FoundThread4 {
    public static void main(String[] args) {
        // 匿名内部类
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名称：" + Thread.currentThread().getName());
            }
        });
        thread.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名称：" + Thread.currentThread().getName());
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
