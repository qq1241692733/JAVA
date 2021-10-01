package found.stop;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 19:21
 */
public class TestDemo3 {
    /**
     * interrupted() 和 isInterrupted() 的区别：
      Thread.interrupted() :
            是全局方法，判断完后会重置状态
             执行了判断线程终止为 true之后，就会将状态重置为 false
        而 Thread.currentThread().isInterrupted() 不会
            因为 Thread.interrupted() 是一个全局的静态方法，一个线程使用完别的线程还可能使用，需要复位
        而 isInterrupted() 方法是拿到当前线程的状态，其他人不会再用，不用复位
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    //System.out.println(Thread.interrupted());
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t1.start();
        t1.interrupt();
        t1.join();
        System.out.println(t1.isInterrupted());
    }
}
