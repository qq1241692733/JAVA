/**
 * Created with IntelliJ IDEA.
      饿汉模式:
        随着类的启动而启动，程序启动后就会创建，但是创建后可能不会使用，从而浪费了系统资源
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/25
 * Time: 20:20
 */


public class ThreadDemo1 {

    static class Singleton {
        // 1.创建私有的构造函数 (防止其他类直接创建)
        private Singleton() {

        }
        // 2.创建私有变量(线程安全)
        private static Singleton singleton = new Singleton();
        // 3.提供公共的获取实例方法
        public static Singleton getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
