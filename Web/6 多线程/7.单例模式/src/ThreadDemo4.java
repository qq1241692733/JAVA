/**
 * Created with IntelliJ IDEA.
 * Description:
      懒汉方式2：

 * User: hong yaO
 * Date: 2021-05-2021/5/25
 * Time: 20:28
 */


public class ThreadDemo4 {
    static class Singleton {
        // 1. 创建私有构造函数防止其他地方直接实例化
        private Singleton() {

        }
        // 2.创建一个私有类对象
        private static Singleton singleton = null;
        // 3.提供统一的访问方法
        public static synchronized Singleton getInstance() {
            //(线程不安全)
            if (singleton == null) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                singleton = new Singleton();
            }
            return singleton;
        }

    }

    private static Singleton s1 = null;
    private static Singleton s2 = null;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new  Thread(new Runnable() {
            @Override
            public void run() {
                s1 = Singleton.getInstance();
            }
        });
        t1.start();

        // 使用主线程执行任务
        s2 = Singleton.getInstance();
        // 等待执行完
        t1.join();
        System.out.println(s1 == s2);
    }
}
