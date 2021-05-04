package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 17:16
 */
public class ThreadState1 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("未开启：" + t1.getState());
        t1.start();
        System.out.println("开启之后：" + t1.getState());
        Thread.sleep(100);
        System.out.println("Sleep中： " + t1.getState());
        t1.join();
        System.out.println("执行完成：" + t1.getState());
    }
}
