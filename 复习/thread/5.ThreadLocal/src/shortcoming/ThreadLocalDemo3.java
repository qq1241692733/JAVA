package shortcoming;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/14
 * Time: 19:37
 */
public class ThreadLocalDemo3 {
    /**
     *  ThreadLocal 缺点:
     *     1.不可继承性
     *        子线程不能读取到父线程的值
     */
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set("JAVA");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String result = threadLocal.get();
                System.out.println("结果：" + result);
            }
        });
        t1.start();
    }
}
