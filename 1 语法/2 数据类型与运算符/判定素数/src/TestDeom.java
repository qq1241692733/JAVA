import java.util.Scanner;
import static java.lang.Math.sqrt;

public class TestDeom {
    public static void main(String[] args) {
        int j=0;
        Scanner scanner=new Scanner(System.in);
        int i= scanner.nextInt();
            for(j=2;j<sqrt(i);j++) {
                if (i%j==0) {
                    break;
                }
            }
            if(j>sqrt(i)) {
                System.out.println(j+"素数");
            }
            else {
                System.out.println(i+"不是素数");
            }
    }
}

