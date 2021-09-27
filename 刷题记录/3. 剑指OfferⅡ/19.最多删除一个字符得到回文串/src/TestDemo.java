/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/27
 * Time: 19:54
 */
public class TestDemo {
    public static void main(String[] args) {
        String s = "deeee"; //1,2
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            }else {
                // s.substring(left, right + 1)
//                return fun(s.substring(left + 1, right + 1)) ||
//                        fun(s.substring(left, right));
                return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left ++;
                right --;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean fun(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
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
