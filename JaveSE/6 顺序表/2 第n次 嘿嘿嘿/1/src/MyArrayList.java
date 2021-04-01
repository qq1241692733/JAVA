import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/2
 * Time: 18:07
 */
//// 打印顺序表
//public void display() {}
//// 判断顺序表是否满
//public boolean isFull() {}
//// 在 pos 位置新增元素
//public void add(int pos, int data) {}
//// 默认插入到数组最后
//public void addLast(int data) {}
//// 2倍扩容
//public void resize() {}
//// 判定书否包含某个元素
//public boolean contains(int toFind) {}
//// 查找某个元素的对应位置
//public int search(int toFine) {}
//// 获取顺序表的长度
//public int size() {}
////获取 pos位置的元素
//public int getPos(int pos) {}
//// 给 pos 位置的元素改为value
//public void setPos(int pos, int value) {}
//// 删除第一次出现的关键字key
//public void remove(int key) {}
//// 清空顺序表
//public void clear() {}
public class MyArrayList {
    private int[] elem;   //默认为null
    private int usedSize;
    public MyArrayList() {
        this.elem = new int[3];
    }


    public MyArrayList(int len) {
        this.elem = new int[len];
    }

    // 打印顺序表
    public void display() {
        if (this.usedSize == 0) {
            System.out.println("啥也没有");
        }
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 判断顺序表是否满
    public boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(isFull()) {
            resize();
        }
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("插入位置不合法");
            return;
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 默认插入到数组最后
    public void addLast(int data) {
        if (isFull()) {
            resize();
        }
        this.elem[this.usedSize] = data;
        usedSize++;
    }

    // 2倍扩容
    public void resize() {
        this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
    }
    // 判定书否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素的对应位置
    public int search(int toFine) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFine) {
                return i;
            }
        }
        return -1;
    }

    // 获取顺序表的长度
    public int size() {
        return this.elem.length;
    }

    //获取 pos位置的元素
    public int getPos(int pos) {
        if (pos < 0 || pos > this.usedSize - 1) {
            return -1;
        }
        return this.elem[pos];
    }

    // 给 pos 位置的元素改为value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos > this.usedSize - 1) {
            return;
        }
        this.elem[pos] = value;
    }

    // 删除第一次出现的关键字key
    public void remove(int key) {
        int index = search(key);
        if (index == -1) {
            System.out.println("没有要删除的元素");
            return;
        }
        for (int i = index; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}
