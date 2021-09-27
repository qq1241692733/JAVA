/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/27
 * Time: 19:28
 */
public class TestDemo {
    public static void main(String[] args) {
        String s = "A,b 3ba";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            }else {
                return false;
            }
        }
        return true;
    }
}
