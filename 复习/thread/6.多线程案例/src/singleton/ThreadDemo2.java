package singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/22
 * Time: 20:42
 */

public class ThreadDemo2 {
    /**
     * 单例模式: 整个程序的运行中只存在一个对象
     *
     * 1.懒汉方式 V1(线程不安全):
     */
    static class Singleton {
        // 1.创建一个私有的构造函数
        private Singleton(){}

        // 2. 创建一个私有的类变量
        private static Singleton singleton = null;
        // 3. 提供统一的访问方法
        public static Singleton getInstance() {
            if (singleton == null) {
                // 第一次访问
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
