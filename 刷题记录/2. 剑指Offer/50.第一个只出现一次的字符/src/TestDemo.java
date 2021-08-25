import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/26
 * Time: 0:56
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    public static char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                return entry.getKey();
//            }
//        }
        // map 中的顺序不是原顺序
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return ' ';
    }
}
