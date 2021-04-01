/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/13
 * Time: 13:16
 */
public class Test {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6};
        printArray(arr);
    }
    public static void printArray(int []arr) {
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
