/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/23
 * Time: 16:03
 */
public class SingletonDemo3 {
    private SingletonDemo3(){}

    private static volatile SingletonDemo3 singletonDemo3 = null;

    private static SingletonDemo3 getInstance() {
        if (singletonDemo3 == null) {
            synchronized (SingletonDemo3.class) {
                if (singletonDemo3 == null) {
                    singletonDemo3 = new SingletonDemo3();
                }
            }
        }
        return singletonDemo3;
    }
}
