import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/28
 * Time: 15:32
 */
public class ThreadDemo2 {
    /**
     *  CountDownLatch 计数器：
     *     缺点: CountDownLatch 计数器的使用是一次性的，当用完一次后就不能再使用了
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +
                            "开始起跑");
                    try {
                        Thread.sleep(1000 * finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "到达终点");

                    latch.countDown();
                }
            }).start();
        }

        // 阻塞等待，当计数器减为 0 时 才会执行后边的代码
        latch.await();
        System.out.println("所有人都到达终点，公布成绩");
    }
}
