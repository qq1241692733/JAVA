package thread_0502;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 10:24
 */
public class FoundThread2 {
    /**
     *创建方法2： 继承 Thread
     */
    public static void main(String[] args) {
        Thread thread= new Thread() {
            @Override
            public void run() {
                System.out.println("线程名称： " +
                        Thread.currentThread().getName());
            }
        };
        thread.start();
    }
}
