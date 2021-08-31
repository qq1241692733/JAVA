import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/30
 * Time: 21:56
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    /**
     * 状态：f(n) 以 n 结尾的最长无重复字符字串
     * 状态方程：if(哈希表里没有): f(n) = f(n  - 1) + 1
     *              else: f(n) = 1, 该字母在哈希表中的v al 设为1
     *  初始状态：
     *  返回：max
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            if (tmp < j -i) {
                tmp = tmp + 1;
            }else {
                tmp = j - i;
            }
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
