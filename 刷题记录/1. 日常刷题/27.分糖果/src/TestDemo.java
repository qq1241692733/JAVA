import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/1
 * Time: 11:36
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return set.size() > candyType.length / 2 ? candyType.length / 2 : set.size();
    }
    public int distributeCandies2(int[] candyType) {
        Arrays.sort(candyType);
        int count = 1;
        for (int i = 1; i < candyType.length; i++) {
            if (candyType[i] > candyType[i - 1]) count ++;
        }
        return count > candyType.length / 2 ? candyType.length / 2 : count;
    }
}
