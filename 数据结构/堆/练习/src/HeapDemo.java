import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:堆
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/29
 * Time: 11:11
 */
public class HeapDemo {
    public int[] elem;
    public int usedSize;

    public HeapDemo() {
        this.elem = new int[10];
    }

    public void adjustDown(int parent, int len) {
        int child = 2*parent+1;  //左孩子
        while (child < len) {
            //child + 1 < len 判断有没有右孩子
            if (child+1 < len && this.elem[child] < this.elem[child+1]) {
                child++;
            }
            if (this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }

    }
    public void crateBigHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }

        for (int i = (this.usedSize - 1)/2; i >= 0 ; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int ret = this.elem[0];
        int temp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[this.usedSize - 1] = temp;

        this.usedSize --;
        adjustDown(0, this.usedSize);
        return ret;
    }

    public void push(int val) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);
        }
        this.elem[usedSize] = val;
        usedSize ++;
        adjustUp(this.usedSize - 1);
    }

    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
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


    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public void show() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    public void heapSort() {
        int end = this.usedSize - 1;
        while (end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end --;
        }
    }
}
