public class TestDemo {
    public static void main(String[] args) {
        int a=10;
        double b=3.1;
        float c=12.1F;
        char ch='a';   //两个字节
        byte d=127;
        boolean t=true;
        final int x=52;
        short q=2;
        short w=3;
       /// w=w+20;
        w+=20;

       // short e1=q+w;
        short e2=(short)(q+w);   //自动提升到4个字节的Int型

        long r=2;
       // int p1=a+r;
        int p2=(int)(a+r);    //大于4字节提升到相对较大的类型
        String str="Hello";
        short a2 =128;
        byte b2 =(byte) a2;
        System.out.println(a2);
        System.out.println(b2);

        System.out.println("a="+a);   //字符拼接
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(ch);
        System.out.println(t);
    }
}
