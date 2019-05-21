package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    //使用一个辅助数组，22ms,9152k
    public static void reOrderArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                list.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                list.add(array[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }

    //借鉴插入排序的思想,12ms，9200k
    public static void reOrderArray1(int[] array) {
        int odd = 0;   //临时保存需要交换位置的奇数
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {   //发现偶数
                for (int j = i + 1; j < array.length; j++) {   //从偶数开始遍历找第一次出现的奇数
                    if ((array[j] & 1) == 1) {   //找到奇数
                        odd = array[j];
                        while (i < j) {    //把[i,j-1]的偶数后移一个位置，
                            array[j] = array[j - 1];
                            j--;
                        }
                        array[i] = odd;   //在空出来的i位置填上奇数
                        i++;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reOrderArray1(a);
    }

}
