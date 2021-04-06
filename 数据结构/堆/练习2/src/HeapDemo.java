import javafx.collections.ObservableArray;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/31
 * Time: 14:41
 */
public class HeapDemo {
    public int[] elem;
    public int usedSize;

    public HeapDemo() {this.elem = new int[10];}

    public void adjustDown(int parent, int len) {
        int child = 2 * parent +1;
        while (child < len) {
            if (child +1 < len && this.elem[child] < this.elem[child +1]) {
                child ++;
            }
            if (this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                parent = child;
                child = 2 * parent +1;
            }else {
                break;
            }
        }
    }
    public void createBigHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize ++;
        }
        //(this.usedSize - 2)/2 是最后一个父亲结点
        for (int i = (this.usedSize - 2)/2 ; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int poll() throws RuntimeException{
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int ret = this.elem[0];
        this.elem[0] = this.elem[usedSize - 1];
        this.usedSize -- ;
        adjustDown(0,usedSize);
        return ret;
    }

    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    public void push(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        this.elem[this.usedSize] = val;
        this.usedSize ++;
        adjustUp(this.usedSize - 1);
    }

    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while(child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }

    }

    //堆排序
    public void heapSort() {
        int end = this.usedSize - 1;
        while(end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[this.usedSize - 1];
            this.elem[usedSize - 1] = tmp;
            adjustDown(0, end);
            end --;
        }
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}
