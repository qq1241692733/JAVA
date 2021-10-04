package attribute.state;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/1
 * Time: 14:36
 */
public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        // 线程休眠
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        System.out.println("start 之前： " + t1.getState());
        t1.start();
        System.out.println("start 之后： " + t1.getState());
        Thread.sleep(100); // 主线程休眠，确保线程 t1 执行到..

        System.out.println("t1 状态：" + t1.getState());
        t1.join();
        System.out.println("执行完成： " + t1.getState());
    }
}
