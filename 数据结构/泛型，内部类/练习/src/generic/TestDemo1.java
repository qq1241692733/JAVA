package generic;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
.u * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-02-2021/2/3
 * Time: 9:38
 */

public class TestDemo1 {
    public static void main(String[] args) {
        String s = "dddccdbba";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            int count = 1;
            if(map.containsKey(c)) {
                map.put(c, count + 1);
            }else {
                map.put(c, count);
            }
        }
        for(int i = 0; i < s.length(); i ++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
