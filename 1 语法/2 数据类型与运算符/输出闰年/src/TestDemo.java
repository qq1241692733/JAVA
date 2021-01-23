public class TestDemo {
    public static void main(String[] args) {
         //输出 1000 - 2000 之间所有的闰年
        for(int year=1000; year<=2000; year++) {
            if(year% 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println(year);
            }
        }
    }
}
