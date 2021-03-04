public class TestDemo {
    public static void main(String[] args) {
        //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
        float num=0;
        float temp=0;
        for(int i=1;i<=100;i++) {
            temp=1/(float)i;
            if(i%2==0) {
                temp=-temp;
            }
            num=num+temp;
        }
        System.out.println(num);
    }
}
