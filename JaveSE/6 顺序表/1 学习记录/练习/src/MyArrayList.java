import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/1
 * Time: 21:13
 */
public class MyArrayList {
    private int[] elem;
    private int usedSize;  //有效数据元素个数

    public MyArrayList() {
        this.elem = new int[5];
    }

    public MyArrayList(int capacity) {       //创建长度为capacity的顺序表
        this.elem = new int[capacity];
    }

    public void display() {                 //打印
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+"  ");
        }
        System.out.println();
    }

    public void add(int pos, int data) {      //插入到pos位置
        if(this.usedSize == this.elem.length) {
//            System.out.println("顺序表为满");
            resize();
//            return;
        }
        if (pos < 0|| pos >this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        usedSize++;
    }

    public void add2(int data) {              //插入到最后
        if (this.usedSize == this.elem.length) {
//            System.out.println("顺序表已满");
            resize();
//            return;
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    public void resize() {                  //拷贝
        this.elem=Arrays.copyOf(this.elem,2*this.elem.length);
    }

    public boolean contains(int toFind) {      //判断是否包含某个元素
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return true;
            }
        }
        return false;
    }

    public int search (int toFind) {        //查找某个元素对应的位置
        for (int i = 0; i < this.usedSize; i++) {
            if (toFind == this.elem[i]) {
                return i;
            }
        }
        return -1;
    }

    public int getPos(int pos) {            //获取pos位置的元素
        if (pos < 0 || pos >= this.usedSize) {
            return -1;
        }
        return this.elem[pos];
    }

    public void setPos(int pos, int value) {   //替换pos位置为value
        if (pos < 0 || pos >= this.usedSize) {
            return;
        }
        this.elem[pos]=value;
    }

    public void remove(int key) {       //删除第一次出现的元素key
        int i = search(key);
        if (i == -1) {
            System.out.println("没有要删除的元素");
            return;
        }
        for (; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    public int size() {                      //获取顺序表的长度
        return this.usedSize+1;
    }

    public void clear() {
        this.usedSize=0;
    }
}


