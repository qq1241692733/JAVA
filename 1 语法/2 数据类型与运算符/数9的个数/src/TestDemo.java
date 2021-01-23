public class TestDemo {
    public static void main(String[] args) {
     //编写程序数一下 1到 100 的所有整数中出现多少个数字9
        int count=0;
        for(byte i=0;i<100;i++) {
            if(i%10==9) {
                count++;
            }
            if(i/10==9) {
                count++;
            }
        }
        System.out.println(count);
    }

}

