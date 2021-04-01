/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/13
 * Time: 12:08
 */
public class Test {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        float avg=avg(arr);
        System.out.println(avg);
    }
    public static float avg(int[] arr) {
        float avg=0;
        int sum=0;
        for(int i=0;i<+arr.length;i++) {
            sum+=arr[i];
        }
        avg=(float) sum/(float)arr.length;
        return avg;
    }
}
