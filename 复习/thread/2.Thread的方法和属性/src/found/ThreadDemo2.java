package found;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/23
 * Time: 17:58
 */
public class ThreadDemo2 {
    /**
     * 线程的分组
     */
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始起跑了:" + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getThreadGroup());
                try {
                    int num = 1 + new Random().nextInt(5);
                    Thread.sleep(1000 * num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我到终点了：" + Thread.currentThread().getName());
            }
        };
        // 定义分组
        ThreadGroup group = new ThreadGroup("百米赛跑");
        // 运动员
        Thread t1 = new Thread(group, runnable, "张三");
        Thread t2 = new Thread(group, runnable, "李四");
        t1.start();
        t2.start();

        // 打印分组  group.list();

        // 等待所有选手到达终点  group活跃度为0
        while (group.activeCount() != 0);
        // 宣布成绩
        System.out.println("宣布成绩");
    }
}
