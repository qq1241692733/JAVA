import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/26
 * Time: 19:41
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abba"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(map.get(ch) + 1, left);  // 更新左下标
            }
            map.put(ch, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int length = s.length();
        if(length == 0) return 0;
        int maxLen = 1;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < length; i ++) {
            set.add(s.charAt(i));
            int len = 1;
            for(int j = i+1; j < length; j ++) {
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
