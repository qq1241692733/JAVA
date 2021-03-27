/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 22:31
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(max3(1,2,3));
    }
    public static int max2(int a,int b) {
        if (a > b) {
            return a;
        }else {
            return b;
        }
    }
    public static int max3(int a, int b, int c) {
        if(max2(a,b) > c) {
            return max2(a,b);
        }else {
            return c;
        }
    }
}
