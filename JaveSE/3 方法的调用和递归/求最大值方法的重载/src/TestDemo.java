/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 22:37
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(max(3,1.0,2.0));
    }
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }
    public static double max(double a, double b) {
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }
    public static double max(int a, double b, double c) {
        if (a > max(b, c)) {
            return a;
        }else {
            return max(b, c);
        }
    }
}
