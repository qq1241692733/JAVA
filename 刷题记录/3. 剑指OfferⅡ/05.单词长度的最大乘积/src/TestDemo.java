import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/22
 * Time: 20:26
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if (hasSameChar2(words[i], words[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    // 超时
    public static boolean hasSameChar1(String word1, String word2) {
        for (char ch1 : word1.toCharArray()) {
            for (char ch2 : word2.toCharArray()) {
                if (ch1 == ch2) return false;
            }
        }
        return true;
    }

    public static boolean hasSameChar2(String word1, String word2) {
        Map<Character, Boolean> map = new HashMap<>();
        for (char ch1 : word1.toCharArray()) map.put(ch1, true);
        for (char ch2 : word2.toCharArray()) {
            if (map.getOrDefault(ch2, false)) return false;
        }
        return true;
    }

    public static boolean hasSameChar3(String word1, String word2) {
        int[] ch = new int[26];
        for (char ch1 : word1.toCharArray()) ch[ch1 - 'a'] = 1;
        for (char ch2 : word2.toCharArray()) {
            if (ch[ch2 - 'a'] == 1) return false;
        }
        return true;
    }
}
