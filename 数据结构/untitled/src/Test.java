/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/21
 * Time: 17:30
 */

class A<T> {
    T value;

    public A(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}

public class Test {
    public static void main(String[] args) {
        A<Integer> integerA = new A<>(10);
        System.out.println(integerA.getValue());
    }
}
