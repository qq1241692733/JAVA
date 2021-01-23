import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:输出n*n的乘法口诀表，n由用户输入。 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/6
 * Time: 14:37
 */
public class TsestDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                int num=j*i;
                System.out.print(i+"*"+j+"="+num+" ");
            }
            System.out.println();
        }
    }
}
