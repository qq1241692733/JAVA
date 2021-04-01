/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-12-28
 * Time: 14:43
 */

public class TestDemo {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,9);
        myArrayList.add(1,19);
        myArrayList.add(2,29);
        myArrayList.display();
        myArrayList.add2(8888);
        myArrayList.add2(11111);
        myArrayList.add2(444444);
        myArrayList.display();
    }



    public static void main2(String[] args) {
        int[] array = {1,2,3};
        int[] array2 = new int[6];
        array2[0] = 1;
        array2[1] = 2;
    }

    public static void swap(int[] array1,int [] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        //alt+enter
        int len = len1 > len2 ? len2 : len1;

        int lena = Math.min(len1,len2);
        for (int i = 0; i < len; i++) {

        }
    }


    public static void main1(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {9,8,7,6,5};
        for(int i = 0;i < array1.length;i++) {
            int tmp = array1[i];
            array1[i] = array2[i];
            array2[i] = tmp;
        }
    }
}
