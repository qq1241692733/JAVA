package demo4;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/17
 * Time: 10:58
 */
interface A {
    void funcA();
}

interface B {
    void funcB();
}

interface C {
    void funcC();
}

interface D extends A,B,C {
    void funcD();
}

class E {

}
class Test extends E implements A,B,C {
    @Override
    public void funcA() {
    }

    @Override
    public void funcB() {

    }

    @Override
    public void funcC() {

    }
}
public class TestDemo {
}
