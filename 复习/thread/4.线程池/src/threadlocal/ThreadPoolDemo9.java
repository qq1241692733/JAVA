package threadlocal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/13
 * Time: 16:37
 */
public class ThreadPoolDemo9 {
    /**
     *  4.ThreadLocal 的初始化方法1：
     *       inutialValue: 初始化
     * 	     inutialValue + get 正常存取操作
     * 	     inutialValue + set  + get  不会执
     *       行初始化方法，先执行 set 方法，再执行get方法
     * 	    为什么 set 之后不会执行初始化，
     *
     *   面试题：什么情况下不会执行 inutialValue 方法？
     *   线程7 ： 34:00
     *   看源码知：
     *      ThreadLocal 是懒加载的，当调用了 get 方法后才会尝试执行 initialValue初始化方法
     *      尝试获取一下 ThreadLocal set 的值，如果获取到了值，那么初始化方法永远不能执行
     */
    static ThreadLocal<String> threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            System.out.println("执行了初始化方法");
            return "java";
        }
    };

    public static void main(String[] args) {
        threadLocal.set("MySQL");
        System.out.println("结果：" + threadLocal.get());
    }
}
