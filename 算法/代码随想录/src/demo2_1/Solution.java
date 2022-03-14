package demo2_1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/1
 * Time: 12:33
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern1("ababab"));
        System.out.println(repeatedSubstringPattern1("abcdab"));
    }
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                int j = 0;
                for (; j < len - i; j ++) {
                    if(s.charAt(j) != s.charAt(j + i)) {
                        break;
                    }
                }
                if (j + i == len) return true;
            }
        }
        return false;
    }
    public static boolean repeatedSubstringPattern1(String s) {
        if (s.equals("")) return false;

        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) j++;
            // 更新 next 数组的值
            next[i] = j;
        }

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}
