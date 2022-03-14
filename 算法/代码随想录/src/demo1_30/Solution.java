package demo1_30;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-01-2022/1/30
 * Time: 13:32
 */
public class Solution {
    public static void main(String[] args) {
        String s = "bbcbbb";
        int[] next = new int[s.length()];
        getNext(next,s);
        System.out.println(Arrays.toString(next));
    }
    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }
}
