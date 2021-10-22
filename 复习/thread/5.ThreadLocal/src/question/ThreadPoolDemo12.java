package question;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/13
 * Time: 16:37
 */
public class ThreadPoolDemo12 {
    /**
     *  与 Demo12 对比
     */
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("java");
        try {
            System.out.println("结果：" + threadLocal.get());
        } finally {
            threadLocal.remove();
        }
        System.out.println("结果：" + threadLocal.get());
    }
}
