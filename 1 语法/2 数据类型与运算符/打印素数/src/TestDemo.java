import static java.lang.Math.sqrt;

public class TestDemo {
    public static void main(String[] args) {
        //打印 1 - 100 之间所有的素数
        int j=2;
        for(int i=2;i<=100;i++) {
            for(j=2;j<sqrt(i);j++) {
                if (i%j==0) {
                    break;
                }
            }
            if(j>sqrt(i)) {
                System.out.println(i);
            }
        }
    }
}
