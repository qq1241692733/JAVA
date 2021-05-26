package 单例模式;

/**
 * Created with IntelliJ IDEA.
 * Description:
      懒汉方式1：

 * User: hong yaO
 * Date: 2021-05-2021/5/25
 * Time: 20:28
 */


public class ThreadDemo2 {
    static class Singleton {
        // 1. 创建私有构造函数防止其他地方直接实例化
        private Singleton() {

        }
        // 2.创建一个私有类对象
        private static Singleton singleton = null;
        // 3.提供统一的访问方法
        public static Singleton getInstance() {
            //(线程不安全)
            if (singleton == null) {
                singleton = new Singleton();
            }
            return singleton;
        }

    }
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
