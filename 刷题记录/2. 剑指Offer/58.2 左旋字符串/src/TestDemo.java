/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/23
 * Time: 23:12
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public static String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        builder = builder.append(s.substring(n, s.length())).append(s.substring(0, n));
        return String.valueOf(builder);
    }
}
