package thread_0502;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  百米赛跑
 *      ThreadGroup group = new ThreadGroup();
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 20:57
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始起跑了:" +
                        Thread.currentThread().getName());
                try {
                    int num = 1 + new Random().nextInt(5);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我到终点了：" +
                        Thread.currentThread().getName());
            }
        };
        // 定义分组
        ThreadGroup group = new ThreadGroup("百米赛跑第一组");
        // 创建运动员
        Thread t1 = new Thread(group,runnable,"张三");
        Thread t2 = new Thread(group,runnable,"李四");
        t1.start();
        t2.start();

        // 打印线程分组详情
        group.list();
        //等待所有选手到达终点
        while (group.activeCount() != 0) {
            // 线程执行完后，活跃度就为0了
        }
        // 宣布成绩
        System.out.println("宣布成绩");
    }
}
