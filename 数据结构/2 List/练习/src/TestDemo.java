/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/21
 * Time: 9:31
 */

import org.omg.CORBA.Object;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * 泛型：
 * 1、自动进行类型检查
 * 2、自动
 * 3、
 *
 */

class MyArrayList <T> {

    public T[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = (T[])new Object[10];
    }
    public void add(T data) {
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    public T get(int pos) {
        return this.elem[pos];
    }
}

public class TestDemo {
//    public static void main(String[] args) {
//        MyArrayList myArrayList = new MyArrayList();
//        myArrayList.add(1);
//        myArrayList.add("he");
//        String str = (String) myArrayList.get(1);
//        System.out.println(str);
//    }

    public static void main2(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
    }

    /**
     * 包装类
     * 装包/装箱 ：把简单类型包装成包装类
     *    自动装包
     *    显示装包

     * @param args
     */
    public static void main3(String[] args) {
        int a = 10;
        Integer integer = new Integer(a);  //显示的装包
        System.out.println(integer);
        Integer integer1 = Integer.valueOf(a);
        System.out.println(integer1);

        Integer integer2 = a;  //自动装包  其实也调用了valueOf

    }

    /**
     * 拆包/拆箱 ：把包装类变成简单类型
     * 自动装包
     * 显示装箱
     */
    public static void main(String[] args) {
        Integer i = 10;
        int a = i;
        System.out.println(a);
        int a2 = i.intValue();
        System.out.println(a2);
        double a3 = i.doubleValue();
        System.out.println(a3);

        Integer a4 = 100;
        Integer a5 = 100;
        System.out.println(a4 == a5);  //查看valueOf源码
    }
}
