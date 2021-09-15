import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/15
 * Time: 16:24
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {2,3};
        System.out.println(combinationSum(arr, 5));
    }

    /**
     * 注意：
     *  candidates {2，3}   target：5
     *     1.剪枝： [2, 2, 2] X， 剪枝 [2, 2, X] 不用遍历 [2, 2, 3],
     *          此时需要最开始时给 candidates 数组排序，保证该层循环 [2, 2, X] 后边都是大于[2, 2, 2] 和的组合
     *     2.防止重复遍历：为防止 [2, 3] 和 [3, 2] 重复
     *          for 循环初始下标应该从 idx 开始，idx = 1 时 遍历 [3,X], 进入下一层dfs X下标从 第一层循环 idx=1 开始遍历，及 [3, 3 X]
     *    错误写法：
     *      1. 此时 sum 已经更新，而 break 后没有回溯，应先判断 sum 有没有超范围，超范围了就无需再更新 sum 的值
     */

    private static List<Integer> list = new ArrayList<>();
    private static int sum = 0;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,0,res);
        return res;
    }

    private static void dfs(int[] candidates, int target, int idx, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            sum += candidates[i];
            // if (sum > target) break;  错误写法：1
            list.add(candidates[i]);
            dfs(candidates, target, i, res);

            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
