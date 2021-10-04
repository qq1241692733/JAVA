package attribute.state;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/1
 * Time: 14:36
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("start 之前： " + t1.getState());
        t1.start();
        System.out.println("start 之后： " + t1.getState());
        //Thread.sleep(100);

        t1.join();
        System.out.println("执行完成： " + t1.getState());
    }
}
