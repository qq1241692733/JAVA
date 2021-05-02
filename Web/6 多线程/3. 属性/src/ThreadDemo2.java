import javax.swing.plaf.TableHeaderUI;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 1:00
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            // 在守护线程的内部创建的线程
            Thread t2 = new Thread(() -> {
            });
            System.out.println("t2：" +
                    (t2.isDaemon() == true? "守护线程":"用户线程"));

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setDaemon(true);  //设置为守护线程
        t1.start();
        System.out.println("t1 是否为守护线程：" + t1.isDaemon());
    }
}
