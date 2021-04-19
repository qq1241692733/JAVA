import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/15
 * Time: 20:21
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        int maxSum = 0;
        if (arr[0] > 0) {
            sum = arr[0];
            maxSum = arr[0];
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                sum = 0;
            }else if (arr[i] == arr[i-1] +1 || arr[i] == arr[i-1]-1) {
                sum = sum + arr[i];
                maxSum = Math.max(sum,maxSum);
            }else {
                sum = arr[i];
                maxSum = Math.max(sum,maxSum);
            }
        }
        System.out.println(maxSum);
    }
}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        int sum = 0;
//        int maxSum = 0;
//        if (arr[0] > 0) {
//            sum = arr[0];
//            maxSum = arr[0];
//        }
//        int ins = -1;
//        for (int i = 1; i < n; i++) {
//            if (arr[i] < 0) {
//                ins = -2;
//            }else if (arr[i] == arr[i-1] +1) {
//                ins = 1;
//            }else if (arr[i] == arr[i-1] - 1) {
//                ins = -1;
//            }else {
//                ins = 0;
//            }
//            if (ins == 1 || ins == - 1) {
//                sum = arr[i] + arr[i -1];
//                maxSum = Math.max(sum,maxSum);
//            }else if (ins == 0){
//                sum = arr[i];
//                maxSum = Math.max(sum,maxSum);
//            }
//        }
//        System.out.println(maxSum);
//    }




