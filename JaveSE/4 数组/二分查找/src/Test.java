/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/14
 * Time: 18:10
 */
public class Test {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,7,8,12};
        System.out.println(binarrySearch(arr, 8));
    }
    public static int binarrySearch(int[] arr,int num) {
        int left=0;
        int right=arr.length-1;
        while(left<=right) {
            int mid=(left+right)/2;
            if(num>arr[mid]) {
                left=mid+1;
            }
            else if(num<arr[mid]) {
                right=mid-1;
            }
            else
                return mid;
        }
        return -1;
    }
}
