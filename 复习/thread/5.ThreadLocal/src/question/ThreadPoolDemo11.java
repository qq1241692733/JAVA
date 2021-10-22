package question;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/13
 * Time: 16:37
 */
public class ThreadPoolDemo11 {
    /**
     *  4.ThreadLocal 的初始化方法2：
     *       withInitial: 初始化
     */
    static ThreadLocal<String> threadLocal =
            ThreadLocal.withInitial(() -> "java");

    public static void main(String[] args) {
        try {
            System.out.println("结果：" + threadLocal.get());
        } finally {
            threadLocal.remove();
        }
        // 没有值就执行初始化方法，那么上边的 remove 还有意义吗？
        // 有意义
        System.out.println("结果：" + threadLocal.get());
    }
}
