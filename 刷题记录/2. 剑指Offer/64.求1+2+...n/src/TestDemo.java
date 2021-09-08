/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/8
 * Time: 20:18
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(sumNums1(4));
    }
    public static int sumNums(int n) {
        boolean flsg = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
    public static int sumNums1(int n) {
        if (n > 0) {
            n += sumNums(n - 1);
        }
        return n;
    }
}
