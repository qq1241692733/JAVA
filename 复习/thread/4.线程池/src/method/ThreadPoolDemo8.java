package method;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/10
 * Time: 20:10
 */
public class ThreadPoolDemo8 {
    /**
     * 4. ThreadLocal 使用：
     *    1.set(T): 将变量存放到线程中
     *    2.get(): 从线程中取得私有变量
     *    3.remove()： 从线程中移除私有变量
     *
     *    4. inutialValue: 初始化
     * 	     inutialValue + get 正常存取操作
     * 	     inutialValue + set  + get  不会执
     *       行初始化方法，先执行 set 方法，再执行get方法
     * 	    为什么 set 之后不会执行初始化，
     *      5. withInitial: 初始化
     */


    // 创建并初始化
    static ThreadLocal<String> threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            System.out.println("执行了初始化方法");
            return "Java";
        }
    };

    public static void main(String[] args) {
        String result = threadLocal.get();
        System.out.println("从 ThreadLocal 读取到：" + result);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 1, 0, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(1000));

        for (int i = 0; i < 2; i++) {
            String res = threadLocal.get();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("得到数据：" + res);
                }
            });
        }
    }
}
