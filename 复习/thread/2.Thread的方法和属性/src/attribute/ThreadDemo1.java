package attribute;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 18:15
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        System.out.println("线程的属性：");
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "张三");
        System.out.println("线程状态：" + t1.getState());
        t1.start();
        System.out.println("启动后线程状态：" + t1.getState());
        System.out.println("线程ID：" + t1.getId());
        System.out.println("线程的名称：" + t1.getName());
        System.out.println("线程优先级：" + t1.getPriority());
        System.out.println("线程是否为后台线程：" + t1.isDaemon());
        System.out.println("线程是否存活：" + t1.isAlive());
        System.out.println("线程是否被中断：" + t1.isInterrupted());

    }
}
