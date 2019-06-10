package 剑指offer;

import java.util.ArrayList;

public class 和为S的两个数 {

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int plow = 0;
        int phigh = array.length - 1;
        int tmpMul = Integer.MAX_VALUE;
        int tmpLow = 0;
        int tmpHigh = 0;
        while (plow < phigh) {
            int cur = array[plow] + array[phigh];
            if (cur == sum) {
                if (array[plow] * array[phigh] < tmpMul) {
                    tmpMul = array[plow] * array[phigh];
                    tmpLow = array[plow];
                    tmpHigh = array[phigh];
                    plow++;
                }
            } else if (cur < sum) {
                plow++;
            } else {
                phigh--;
            }
        }
        result.add(tmpLow);
        result.add(tmpHigh);
        return result;
    }

    public static void mian(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 4, 5};
        FindNumbersWithSum(a, 5);
    }
}
