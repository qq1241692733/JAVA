import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/26
 * Time: 19:18
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a'] --;
            count[p.charAt(i) - 'a'] ++;
        }
        if (isAllZero(count)) res.add(0);
        int left = 0;
        int right = p.length();
        while (right < s.length()) {
            count[s.charAt(left++) - 'a'] ++;
            count[s.charAt(right++) - 'a'] --;
            if (isAllZero(count)) res.add(left);
        }
        return res;
    }
    public static boolean isAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0 ) return false;
        }
        return true;
    }
}
