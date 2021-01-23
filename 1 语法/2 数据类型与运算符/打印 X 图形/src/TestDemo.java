import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        //键盘输入要打印 X 图形的行
        Scanner scanner=new Scanner(System.in);
        int i=scanner.nextInt();
        for(int j=1;j<=i;j++){
            for(int l=1;l<=i;l++){
                if(l==j||l==i+1-j) {
                    System.out.print("*");
                }
                else
                    System.out.print(" ");

            }
            System.out.println();
        }
    }
}
