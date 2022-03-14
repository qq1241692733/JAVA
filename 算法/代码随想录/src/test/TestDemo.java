package test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-01-2022/1/10
 * Time: 20:52
 */
public class TestDemo {
    public static void main(String[] args) {
        //backspaceCompare("ab#c", "ac#c");
        //char[] a = {'a','b'};
        //System.out.println(String.valueOf(a).substring(0, 1));
        //System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        //System.out.println(totalFruit(new int[]{0,1,2,2}));
        String s = "ad";
        s.trim();

        //System.out.println(spiralOrder(new int[][]{{1,2}}));
        //System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println(Arrays.toString(splitWords1("the skt is blue")));
    }

    public static String[] splitWords1(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                list.add(String.valueOf(builder));
                builder = builder.delete(0, builder.length());
            } else {
                builder.append(s.charAt(i));
            }
        }
        list.add(String.valueOf(builder));
        String[] res = new String[list.size()];
        int i = 0;
        for (String str : list) {
            res[i++] = str;
        }
        return res;
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;

        while (num <= n*n) {
            for (int i = left; i <= right; i++) {
                res[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                res[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        return res;
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i --) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
    public static String minWindow(String s, String t) {
        int left = 0;
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> windowsMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        int valid = 0;  // 滑动窗口中能覆盖的字符种类数
        for (char ch : t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (mapT.containsKey(r)) {
                // 字串 t 中有右指针位置字符, 保存滑动窗口字符的Map记录该字符出现的次数
                windowsMap.put(r, windowsMap.getOrDefault(r, 0) + 1);
                if (windowsMap.get(r).equals(mapT.get(r))) {
                    valid++;
                }
            }
            // 成功覆盖字串，缩小窗口，更新最小字串
            while (mapT.size() == valid) {
                // 更新最小字串
                if (right - left < minLen) {
                    res = s.substring(left, right + 1);
                    minLen = Math.min(minLen, right - left + 1);
                }
                // 记录下左指针位置字符,缩小窗口
                char l = s.charAt(left);
                left++;
                // 要是左指针位置字符是字串中的字符 A...BBB...C..A
                if (windowsMap.containsKey(l)) {
                    if (mapT.get(l).equals(windowsMap.get(l))) {
                        // 若子串为 ABC， 那么 A...BBB...C..A，只有是BBB最后一个时，才需要 valid--，故要做此判断
                        valid--;
                    }
                    windowsMap.put(l, windowsMap.get(l) - 1);
                    //windowsMap.put(l, windowsMap.getOrDefault(l, 0) - 1);
                }
            }

        }
        return res;
    }
    public static boolean mySqrt(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + (right - right) / 2;
            System.out.println(mid);
            if ((long)mid * mid > num) {
                right = mid - 1;
            } else if ((long)mid * mid < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    public static String build(String str) {
        char[] ch = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '#') {
                stack.push(ch[i]);
            }
            if (ch[i] == '#' && stack.empty() == false) {
                stack.pop();
            }
        }
        System.out.println(stack.toString());
        return stack.toString();
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            while (sum < target && right < nums.length) {
                sum += nums[right++];
            }
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static int totalFruit(int[] fruits) {
        int left = 0;
        int maxLen = 0;
        int[] count = new int[fruits.length];
        int size = 0;
        for (int right = 0; right < fruits.length; right ++) {
            if (count[fruits[right]] == 0) size++;
            count[fruits[right]]++;
            // 滑动窗口内水果种类大于 2 个时
            while (size > 2) {
                count[fruits[left]]--;
                if (count[fruits[left]] == 0) {
                    size--;
                }
                left++;
            }
            // 扩大窗口的时候更新 最大长度
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
