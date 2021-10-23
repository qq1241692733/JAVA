/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/23
 * Time: 15:58
 */
public class SingletonDemo2 {
    // 1.创建私有的构造方法
    private SingletonDemo2(){}
    // 2.创建私有的类变量
    private static SingletonDemo2 singletonDemo2 = null;
    // 3.提供公共的获取实例的方法
    private static synchronized SingletonDemo2 getInstance() {
        if (singletonDemo2 == null) {
            singletonDemo2 = new SingletonDemo2();
        }
        return singletonDemo2;
    }
}
