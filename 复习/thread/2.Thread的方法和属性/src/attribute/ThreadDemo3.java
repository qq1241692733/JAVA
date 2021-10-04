package attribute;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 18:32
 */


public class ThreadDemo3 {
    /**
     * 守护线程（后台线程）和用户线程
     *      守护线程是用来服务用户线程的，用户线程就是上帝，守护线程就说服务员
     *      进程退出： 没有用户线程运行，进程就会退出
     *  t1.setDaemon()：
     *      false： 用户线程
     *      true：  守护线程
     *      默认为 false
     *  守护线程的使用场景：
     *      Java 垃圾回收器
     *      Tcp 健康检测
     *   注意事项：
     *      1.守护线程设置必须在线程开启之前，如果设置守护线程在线程启动后设置，程序会报错，并且设置无效
     *      2.在守护线程里边创建的线程是守护线程
     *      3.在用户线程里边创建的线程是用户线程
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setDaemon(true); // 设置为守护线程
        t1.start();
        System.out.println("t1 是否为守护线程：" + t1.isDaemon());
//
//        Thread t2 = new Thread(() -> {
//            Thread t3 = new Thread(() -> {
//            });
//            System.out.println("t3 是否为守护线程：" +t3.isDaemon());
//        });
//        t2.setDaemon(true);
//        t2.start();
    }
}
