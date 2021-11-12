import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/6
 * Time: 18:09
 */
public class ThreadDemo2 {
    private byte[] bytes = new byte[5 * 1024 * 1024]; // 5M
    public ThreadDemo2 obj = null;

    public static void main(String[] args) {
        ThreadDemo2 t1 = new ThreadDemo2();
        ThreadDemo2 t2 = new ThreadDemo2();
        // 循环引用
        t1.obj = t2;
        t2.obj = t1;
        // 释放对象
        t1 = null;
        t2 = null;
        // 强制垃圾回收
        System.gc();
    }
}
