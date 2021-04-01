import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} ,
 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
 * User: hong yaO
 * Date: 2020-12-2020/12/14
 * Time: 18:40
 */
public class Test {
    public static void main(String[] args) {
    int[] arr={1,2,3};
    String str=myToString(arr);
    System.out.println(str);
    }

    public static String myToString(int[] arr) {
        String str="{";
        for (int i = 0; i < arr.length-1; i++) {
            str=str+arr[i]+","+" ";
        }
        str=str+arr[arr.length-1]+"}";
        return str;
    }
}
