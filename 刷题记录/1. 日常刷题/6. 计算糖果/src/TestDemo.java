import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
    题目： A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息:
     A-B,B - C,A+B,B＋C.这四个数值.每个字母代表每个人所拥有的糖果数.
     现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有—组整数A,B,C满足所有题设条件。
    如输入：1 -2 3 4
     输出： 2 1 3
 * User: hong yaO
 * Date: 2021-04-2021/4/14
 * Time: 20:41
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] arr = new float[4];
        for (int i = 0; i < 4; i++) {
            float num = scanner.nextFloat();
            arr[i] = num;
        }
        float A = (arr[0] + arr[2]) / 2;
        float B = A - arr[0];
        float C = B - arr[1];
        if (A % 1 == 0 && B % 1 == 0 && C % 1 == 0 && (int)A >= 0 && (int)B >= 0 && (int)C >= 0) {
            if (B + C == arr[3]) {
                System.out.println((int)A+" "+(int)B+" "+(int)C);
            }else {
                System.out.println("NO");
            }
        }else {
            System.out.println("NO");
        }
    }
}
