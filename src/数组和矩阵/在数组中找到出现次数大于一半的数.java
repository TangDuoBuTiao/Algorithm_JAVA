package 数组和矩阵;
/*  《在数组中找到出现次数大于一半的数》
 * 给定一个整型数组arr，打印其中出现次数大于一半的数，如果没有这样的数，打印提示信息。
 * 要求：时间复杂度O(N), 额外空间复杂度O(1)
 * 解法：次数大于一半的数，最多有一个，或者没有。
 *      一次在数组中删掉2个不同的数，不停的删除，知道剩下的数只有一种，
 */

public class 在数组中找到出现次数大于一半的数 {
    public static void printHalfMajor(int[] arr) {
        int cand = 0;
        int times = 0;
        for (int i = 0; i != arr.length; i++) {
            if (times == 0) {
                cand = arr[i];
                times = 1;
            } else if (arr[i] == cand) {
                times++;
            } else {
                times--;
            }
        }
        times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cand) {
                times++;
            }
        }
        if (times > arr.length / 2) {
            System.out.println(cand);
        } else {
            System.out.print("no such number!");
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 3, 1, 4, 1, 1};
        printHalfMajor(a);
    }
}
