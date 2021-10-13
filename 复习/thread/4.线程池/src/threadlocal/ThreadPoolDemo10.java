package threadlocal;

import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/13
 * Time: 16:37
 */
public class ThreadPoolDemo10 {
    /**
     *  4.ThreadLocal 的初始化方法2：
     *       withInitial: 初始化
     */
    static ThreadLocal<String> threadLocal =
            ThreadLocal.withInitial(new Supplier<String>() {
                @Override
                public String get() {
                    System.out.println("执行了初始化方法");
                    return "Java";
                }
            });

    public static void main(String[] args) {
        // todo: remove(很重要)
        System.out.println("结果：" + threadLocal.get());
    }
}
