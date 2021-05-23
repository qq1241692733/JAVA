package Thread的缺点;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 16:47
 */
public class ThreadLocal1 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        MyTask t1 = new MyTask();
        t1.start();

        MyTask t2 = new MyTask();
        t2.start();
    }

    static class MyTask extends Thread {
        // 标识是否第一次访问
        static boolean first = true;

        @Override
        public void run() {
            if (first == true) {
                // 存储用户信息
                threadLocal.set(this.getName() +
                        " session info");
                first = false;
            }
            //
            String result = threadLocal.get();
            System.out.println(this.getName() +
                    ":" + result);
        };
    }
}
