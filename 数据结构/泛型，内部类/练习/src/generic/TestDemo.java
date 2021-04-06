package generic;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-02-2021/2/3
 * Time: 9:06
 */

/**
 * 泛型：
 * 1、class MyStack<T>, <T>是一个占位符，表示当前类是一个泛型类
 * 2、
 * @param <T>
 */
class MyStack<T> {
    public T[] elem;
    public int top;
    public MyStack () {
        this.elem =  (T[])new Object[10];
    }
    public void push(T val) {
        this.elem[top] = val;
        top ++;
    }
    public T getTop() {
        return this.elem[top - 1];
    }
}
public class TestDemo {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        int a = myStack.getTop();
        System.out.println(a);

        //不指定泛型的类型参数 意义： 兼容旧版本
        MyStack myStack1 = new MyStack();
        myStack1.push("ag");
    }
}
