/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/12
 * Time: 17:01
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public static int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a = a^b;
            b = c;
        }
        return a;
    }
}
