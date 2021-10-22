package shortcoming;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/14
 * Time: 19:54
 */
public class ThreadLocalDemo6 {
    /**
     *  ThreadLocal 缺点:
     *    2.脏读
     *      在一个线程中读取到了不属于自己的数据
     *
     *    非脏读正常代码演示
     */
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        MyTask t1 = new MyTask();
        t1.start();

        MyTask t2 = new MyTask();
        t2.start();
    }

    static class MyTask extends Thread {
        // 标识是否第一次访问
        static boolean isFirst = true;

        @Override
        public void run() {
            if (isFirst) {
                // 第一次访问，存储用户信息
                threadLocal.set(this.getName() + "session info");
                isFirst = false;
            }
            String result = threadLocal.get();
            System.out.println(this.getName() + ": " + result);
        }
    }
}
