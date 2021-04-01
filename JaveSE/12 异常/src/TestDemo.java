import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/18
 * Time: 17:08
 */

public class TestDemo {
    /**
     * throws : 声明异常 提醒调用者处理这些异常
     * throw ： 抛出异常
     */
    public static void func2 (int y) throws ArithmeticException{
        if (y == 0) {
            throw new ArithmeticException("抛出除 0 异常");
        }
        System.out.println(10/y);
    }
    private static void testMethod(){

        System.out.println("testMethod");

    }

    public static void main(String[] args) {

        ((TestDemo)null).testMethod();

    }


    public static void main7(String[] args) {
        try {
            func2(0);
        }  catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("6");
    }

    public static void main6(String[] args) {
            func2(0);
        System.out.println("6");
    }

    public static int func () {
        try {
            int ret = 10 / 3;
            return ret;
        } catch (ArithmeticException  e) {
            e.printStackTrace();
        } finally {
            //***************
            return 10;
        }
    }
    public static void main5(String[] args) {
        System.out.println(func());
    }

    public static void main4(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();
            System.out.println("num = " + num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 肯定发会被执行，不管有没有发生异常");
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        try {
            System.out.println("num = " + num);
        } catch (Exception e) {
             e.printStackTrace();
        } finally {
            sc.close();
            System.out.println("finally 肯定发会被执行，不管有没有发生异常");
        }
    }

    public static void main2(String[] args) {
        int[] arr = {1, 2, 3};

        try {
            System.out.println("before");
            System.out.println(arr[100]);
            System.out.println("after");   //上边异常，这里不执行
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try");
    }

    public static void main1(String[] args) {
        try{
            System.out.println(10/0);
        } catch (ArithmeticException e) {  //处理异常
            e.printStackTrace();
        } finally {    //不管会不会发生异常都会被执行  用于释放资源
            System.out.println("finally");
        }
        System.out.println("asfagjthe");
    }
}
