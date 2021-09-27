/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/27
 * Time: 20:24
 */
public class TestDemo {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < 2 * len - 1; i++) {
            int left = i / 2;
            int right = (i + 1) / 2;
            while (left >= 0 && right < len) {
                if (s.charAt(left) == s.charAt(right)) {
                    count ++;
                    left --;
                    right ++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
}
