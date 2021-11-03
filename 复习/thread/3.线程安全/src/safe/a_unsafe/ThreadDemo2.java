package safe.a_unsafe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/2
 * Time: 16:05
 */
public class ThreadDemo2 {
    /**
     * 内存不可见性，导致线程不安全
     *   volatile 作用：修饰的共享变量，可以保证可见性
     *      1.禁止指令从排序
     *      2.当操作完变量后 强制删除工作内存中的此变量
     * volatile 不能解决原子性问题，用 volatile修饰 TestDemo1中的 num 无效
     */
    // private static volatile boolean flag = false;
    private static boolean flag = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {
                    // System.out.println("正在执行");
                    /**
                     * 线程的工作方式：
                     *    每个线程都有自己的工作内存，先在工作内存里找，再取主内存里找
                     *
                     * 当 flag没有用 volatile修饰的时候：
                     *    while(){ 无内容 }: 不删除工作内存的缓存。 (编译器优化)
                     *       t1 工作内存flag一直为 false，所以回一直死循环
                     *    有内容，变量更新主内存，删除工作内存的该变量，每次就从工作内存里读取，工作内存不做缓存
                     */
                }
                System.out.println("终止执行");
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
                System.out.println("flag:" + flag);
            }
        });
        t2.start();
    }
}
