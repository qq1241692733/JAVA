import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
     题目描述
      给定一个字符串和一个词典dict，确定s是否可以根据词典中的词分成
      一个或多个单词。
      比如，给定
      s = "leetcode"
      dict = ["leet", "code"]
      返回true，因为"leetcode"可以被分成"leet code"
 
    https://leetcode-cn.com/problems/word-break/

 * User: hong yaO
 * Date: 2021-07-2021/7/20
 * Time: 17:04
 */
public class TestDemo {
    public static void main(String[] args) {
        boolean[] a = new boolean[3];
        System.out.println(Arrays.toString(a));

        List<String> dict = new LinkedList<String>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak("leetcode", dict));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return false;
        boolean[] canBreak = new boolean[s.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(0,i))) {
                //（0，i]  1到i整体能否被找到
                canBreak[i] = true;
                continue;
            }
            for (int j = i - 1; j > 0; j--) {
                // F(j)
                if (canBreak[j] && wordDict.contains(s.substring(j,i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    //逻辑优化
    public static boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // F(j)
                if (canBreak[j] && wordDict.contains(s.substring(j,i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    //效率优化
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
