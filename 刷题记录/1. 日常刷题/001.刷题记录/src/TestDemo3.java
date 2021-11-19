import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/19
 * Time: 22:38
 */
public class TestDemo3 {
    public static void main(String[] args) {

    }
    // 递归
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        } else {
            return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
        }
    }
    // 记忆化搜索
    Map<Integer, Integer> map = new HashMap<>();
    public int integerReplacement1(int n) {
        if (n == 1) {
            return 0;
        }
        if (!map.containsKey(n)) {
            if (n % 2 == 0) {
                map.put(n, integerReplacement1(n / 2) + 1);
            } else {
                map.put(n, 2 + Math.min(integerReplacement1(n / 2), integerReplacement1(n / 2 + 1)));
            }
        }
        return map.get(n);
    }
}
