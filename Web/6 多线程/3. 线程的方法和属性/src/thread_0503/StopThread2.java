package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
       用线程提供的终止方法 Interrupt 来终止线程
        终止线程： interrupt()
        判断线程的终止状态： interrupted()

 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 11:11
 */
public class StopThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                       // e.printStackTrace();
                        break;
                    }
                    System.out.println("正在转账");
                }
                System.out.println("终止线程");
            }
        });
        t1.start();

        Thread.sleep(310);
        System.out.println("有内鬼，停止交易");
        t1.interrupt();  // 终止线程
    }
}
