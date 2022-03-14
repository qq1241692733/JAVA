package demo2_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/2
 * Time: 10:13
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("F R  I   E    N     D      S      "));
    }
    public static String reverseWords(String s) {
        //s = s.trim();
        //String[] arr = s.split(" ");
        //StringBuilder sb = new StringBuilder();
        StringBuilder sb = removeSpace(s);
        List<String> list = splitBySpace(sb);
        sb = new StringBuilder();
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) != "") {
                sb.append(list.get(i)).append(' ');
            }
        }
        sb.append(list.get(0));
        return String.valueOf(sb);
    }
    public static List<String> splitBySpace(StringBuilder sb) {
        List<String> list = new ArrayList<>();
        int left = 0;
        int right = left + 1;
        while (left < sb.length()) {
            while (right < sb.length() && sb.charAt(right) != ' ') right++;
            list.add(sb.substring(left, right));
            left = right + 1;
            right = left + 1;
        }
        return list;
    }

    public static StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') left++;
        while (s.charAt(right) == ' ') right--;
        while (left <= right) {
            if (s.charAt(left) != ' ' || s.charAt(left - 1) != ' ') {
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb;
    }
}
