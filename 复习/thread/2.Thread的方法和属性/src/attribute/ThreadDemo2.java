package attribute;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 18:19
 */
public class ThreadDemo2 {
    /**
      优先级：1 - 10
            优先级越高执行的优先级越高，执行权也就越大，但是CPU 的调度是
         很复杂的，所以不会严格按照优先级的排序去执行，但总体来看还是优先级
         越高越执行的权重越高
      */

    // 优先级演示
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名：" + Thread.currentThread().getName());
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(runnable, "t1");
            Thread t2 = new Thread(runnable, "t2");
            Thread t3 = new Thread(runnable, "t3");
            t1.setPriority(Thread.MIN_PRIORITY);  // 1
            t2.setPriority(Thread.MAX_PRIORITY);  // 10
            t1.start();
            t2.start();
            t3.start();
        }
    }
}
