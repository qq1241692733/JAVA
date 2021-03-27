/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 23:10
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(fac(3));
    }
    public static int fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n-1);
    }
}
