/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/13
 * Time: 12:18
 */
public class Test {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int add=sum(arr);
        System.out.println(add);
    }
    public static int sum(int[] arr) {
        int add=0;
        for(int i=0;i<arr.length;i++) {
            add+=arr[i];
        }
        return add;
    }
}

