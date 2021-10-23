/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/23
 * Time: 15:51
 */
public class SingletonDemo1 {
    // 1.创建私有的构造函数
    private SingletonDemo1() {}
    // 2.创建一个私有的类变量
    private static SingletonDemo1 singleton = new SingletonDemo1();
    // 3.提供公共的获取实例的方法
    private static SingletonDemo1 getInstance() {
        return singleton;
    }
}
