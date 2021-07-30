import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
     假如有编号为1~3的3张扑克牌和编号为1~3的3个盒子，现在需要将3张牌分别放到3个盒子中去，且每个盒子只能放
  一张牌，一共有多少种不同的放法
 * User: hong yaO
 * Date: 2021-07-2021/7/30
 * Time: 17:42
 */
public class TestDemo {
    public static void main(String[] args) {
        int n = 3;
        int[] box = new int[n + 1];
        int[] used = new int[n + 1];
        int[] solution = new int[n];
        Dfs(box,used,1,solution);
    }

    /**
     * DFS(当前这一步的处理逻辑) {
     *  1.判断边界，是否已经一条道走到黑了：向上回退
     *  2. 尝试当下的每一种可能
     *  3.确定一种可能之后，继续下一步 Dfs(下一步)
     * }
     */
    public static void Dfs(int[] box, int[] used, int idx,int[] solution) {
        // 边界
        if (idx == box.length) {
            for (int i = 0; i < solution.length; i++) {
                solution[i] = box[i + 1];
            }
            System.out.println(Arrays.toString(solution));
            return;
        }

        for (int i = 1; i <= box.length - 1; i++) {
            // 处理当前盒子
            if (used[i] == 0) {
                box[idx] = i;
                used[i] = 1;;
                // 处理下一个盒子
                Dfs(box,used,idx + 1,solution);
                used[i] = 0;
            }
        }
    }
}
