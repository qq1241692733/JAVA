import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
     https://blog.csdn.net/jiaodaqiaobiluo/article/details/120384771
 * User: hong yaO
 * Date: 2021-09-2021/9/25
 * Time: 19:19
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(checkInclusion("bc", "abcdef"));
    }

    // https://blog.csdn.net/jiaodaqiaobiluo/article/details/120384771
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] count = new int[6];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a'] ++;
            count[s2.charAt(i) - 'a'] --;
        }
        if (allAllZero(count)) return true;
        int left = 0;
        int right = s1.length();
        while (right < s2.length()) {
            count[s2.charAt(left++) - 'a'] ++;
            count[s2.charAt(right++) - 'a'] --;
            if (allAllZero(count)) return true;
        }
        return false;
    }
    public static boolean allAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }
}

