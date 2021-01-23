public class TestDemo {
    public static void main(String[] args) {
        //求出0～999之间的所有“水仙花数”并输出
        // “水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身
        // 如:153＝1^3＋5^3＋3^3，所以153是一个“水仙花数“
        for(int i=1;i<1000;i++) {
            int a=0;
            int b=i;
            int c=0;
//            a=i%10;
//            b=i/10%10;
//            c=i/10/10%10;
//            c=c*c*c+b*b*b+a*a*a;
            while(b!=0) {
                a=b%10;
                b=b/10;
                c=c+a*a*a;
            }
            if(c==i) {
                System.out.println(i);
            }
        }
    }
}

///**
// * Created with IntelliJ IDEA.
// * Description:获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
// * User: hong yaO
// * Date: 2020-12-2020/12/6
// * Time: 14:32
// */
//public class TestDemo {
//    public static void main(String[] args) {
//
//        for(int i=1;i<999999;i++) {
//            int a=0;
//            int b=i;
//            int c=0;
//            int n=0;
//            int num=i;
//            while(num!=0) {
//                n++;
//                num/=10;
//            }
//
//            while(b!=0) {
//                a=b%10;
//                b=b/10;
//                c=c+ (int) Math.pow(a,n);
//            }
//
//            if(i==c) {
//                System.out.println(i);
//            }
//        }
//
//    }
//}
