package shortcoming;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/14
 * Time: 19:37
 */
public class ThreadLocalDemo5 {
    /**
     *  ThreadLocal 缺点:
     *     1.不可继承性
     *        子线程不能读取到父线程的值
     *      解决： 使用 new I24nheritableThreadLocal<>();
     *       注意：InheritableThreadLocal不能实现不同线程之间的数据共享
     */
    static ThreadLocal<String> threadLocal =
            new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("JAVA");
                System.out.println("线程t1 设置了值");
            }
        });
        t1.start();

        t1.join();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String result = threadLocal.get();
                System.out.println("线程t2 得到结果：" + result);
            }
        });
        t2.start();
    }
}
