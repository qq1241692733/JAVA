public class TestDemo {
    public static void main(String[] args) {
        //求两个正整数的最大公约数
        // 18  12
        // 18/12=1...6  （辗转相除法）
        // 12/6=2...0   最大公约数为6
        int a=18;
        int b=12;
        if(a<b) {
            int temp=a;
            a=b;
            b=a;
        }
        while (b!=0) {
            int num=a%b;
            a=b;
            b=num;
        }
        System.out.println(a);
    }
}
