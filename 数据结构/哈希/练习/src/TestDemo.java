import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-02-2021/2/16
 * Time: 9:29
 */
public class TestDemo {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.push(1,2);
        hashBuck.push(2,2);
        hashBuck.push(23,23);
        hashBuck.push(4,4);
        hashBuck.push(5,5);
        String s = "ab";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int maxLen = 1;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i ++) {
            set.add(s.charAt(i));
            int len = 1;
            for(int j = i+1; j < s.length(); j ++) {
                if(!set.contains(s.charAt(j))) {
                    len ++;
                    set.add(s.charAt(j));
                }else {
                    set.clear();
                    break;
                }
                if(len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }
}
