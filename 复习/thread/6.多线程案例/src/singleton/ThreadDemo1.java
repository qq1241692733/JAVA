package singleton; /**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/22
 * Time: 20:32
 */

/**
 * 单例模式: 整个程序的运行中只存在一个对象
 *
 * 1.饿汉方式:
 *    先创建
 *  缺点：程序启动之后就会创建，但是创建完了之后可能不会使用，从而浪费了系统资源
 */
class Singleton {
    // 1.创建私有的构造函数,为了防止其他类直接创建
    private Singleton(){

    }
    // 2.定义私有变量(线程安全)
    private static Singleton singleton = new Singleton();

    // 3.提供公共的获取实例的方法
    public static Singleton getInstance() {
        return singleton;
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
       // 不能直接创建 Sigleton singleton = new Singleton();

        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
