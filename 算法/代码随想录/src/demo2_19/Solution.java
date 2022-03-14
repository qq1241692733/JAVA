package demo2_19;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
//        System.out.println(s.combine(4, 2));
    }
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> list = new ArrayList();
//    public List<List<Integer>> combine(int n, int k) {
//        backtracking(n, k, 1);
//        return res;
//    }
//    public void backtracking(int n, int k, int start) {
//        if (k-- == 0) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = start; i <= n; i++) {
//
//            list.add(i);
//            backtracking(n, k, i + 1);
//            list.remove(list.size() - 1);
//        }
//    }
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        String[] numString = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        backtracking(digits, numString, 0);
        return res;
    }
    public void backtracking(String digits, String[] numString, int deep) {
        if (deep == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String s = numString[digits.charAt(deep) - '0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtracking(digits, numString, deep + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}