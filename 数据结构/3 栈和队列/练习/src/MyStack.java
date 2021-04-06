import java.nio.charset.StandardCharsets;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/22
 * Time: 12:06
 */
public class MyStack {
    private int[] elem;
    private int pop;
    public MyStack() {
        this.elem = new int[10];
    };

    public boolean isFull() {
        return this.pop == this.elem.length;
    }
    public int push (int item) {
        if (isFull()) {
            return -1;
        }
        this.elem[this.pop] = item;
        this.pop++;
        return this.elem[this.pop - 1];
    }

    public int peek (int item) {

    }

    public int pop(){
        if (empty()) {
            throw new RuntimeException("栈为空");
        }return this.elem[this.pop -1];
    }

    public boolean empty{

    }
    public int size() {
        for (int i = 0; i < ; i++) {

        }
        return this.pop;
    }
}
