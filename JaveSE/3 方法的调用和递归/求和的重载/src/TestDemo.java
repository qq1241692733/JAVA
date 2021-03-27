/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 22:44
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(add(1,2));
        System.out.println(add(1.1,2.2,3.3));
    }
    public static int add(int a, int b) {
        return a+b;
    }
    public static double add(double a, double b, double c) {
        return a+b+c;
    }
}
