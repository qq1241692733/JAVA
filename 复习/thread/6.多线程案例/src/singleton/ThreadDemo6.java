package singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/22
 * Time: 20:42
 */

public class ThreadDemo6 {
    /**
     * 单例模式: 整个程序的运行中只存在一个对象
     *
     * 1.懒汉方式最终版 V4(线程安全) :
     *     解决线程不安全：
     *         1.双重校验🔒
     *         2.volatile
     */
    static class Singleton {
        // 1.创建一个私有的构造函数
        private Singleton(){

        }

        // 2. 创建一个私有的类变量
        private static volatile Singleton singleton = null;
        // 3. 提供统一的访问方法
        public static Singleton getInstance() throws InterruptedException {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        // 第一次访问
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }

    private static Singleton s1 = null;
    private static Singleton s2 = null;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s1 = Singleton.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s2 = Singleton.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(s1 == s2);
    }
}
