import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
       /*  根据输入的年龄, 来打印出当前年龄的人是少年(低于18),
           青年(19-28), 中年(29-55), 老年(56以上)*/
        Scanner scanner=new Scanner(System.in);
        int eag=scanner.nextInt();
        if(eag<=18){
            System.out.println("少年");
        }
            else if(eag<=28) {
                System.out.println("青年");
            }
                else if(eag<=55) {
                    System.out.println("中年");
                }
                    else {
                        System.out.println("老年");
                    }
    }
}

