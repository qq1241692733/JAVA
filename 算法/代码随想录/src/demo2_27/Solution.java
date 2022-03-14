package demo2_27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{5,2,1}, 6));
        System.out.println(s.combinationSum4(new int[]{1,2,3}, 4));
        List<String> list = new ArrayList<>();
        list.add("ab");
        list.add("cd");


        System.out.println(wordBreak("abcd", list));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int j = 1; j <= len; j++) {
            for (int i = 0; i < j; i++) {
                dp[j] = dp[i] && set.contains(s.substring(i, j));
                if (dp[j]) break;
            }
        }
        return dp[len];
    }
    public int coinChange(int[] coins, int amount) {
        int row = coins.length;
        int max = Integer.MAX_VALUE;

        int[][] dp = new int[row + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = max;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1] && (dp[i][j - coins[i - 1]] != max)) {
                        dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row][amount];
    }

    public int combinationSum4(int[] nums, int target) {
        int row = nums.length;
        int[][] dp = new int[row + 1][target + 1];
        dp[0][0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 1; i <= row; i++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row][target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int row = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum - target) % 2 == 1) return 0;
        int smallSum = (sum - target) / 2;
        
        int[][] dp = new int[row + 1][smallSum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j <= smallSum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }   
            }
        }
        return dp[row][smallSum];
    }
}