import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/28
 * Time: 0:55
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            float ret = func1(n) / sum(n) *100;
            System.out.println(String.format("%.2f",ret)+"%");
        }
    }
    public static float func1(int n) {
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }else {
            return (n-1)*(func1(n-1)+func1(n-2));
        }
    }

    public static float sum(int n) {
        int sum = 1;
        while (n != 0) {
            sum *= n;
            n --;
        }
        return sum;
    }
}