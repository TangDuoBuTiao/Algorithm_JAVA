package 剑指offer;
/*
 * 双指针技术：相当于有一个窗口，窗口的左右两边就是两个指针，
 *          根据窗口内的值之和来确定窗口的位置和宽度。
 */

import java.util.ArrayList;

public class 和为S的连续正数序列 {

    public ArrayList<ArrayList<Integer>> FindContinuousSeq(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int plow = 1;
        int phigh = 2;
        while (phigh > plow) {   //求和公式是（a0 + an）* n / 2
            int cur = (plow + phigh) * (phigh - plow + 1) / 2;
            //如果窗口内的值等于sum
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = plow; i <= phigh; i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
            }
            //如果当前窗口内的值之和小于sum, 那么右边窗口右移一下
            else if(cur < sum){
                phigh++;
            //如果当前窗口内的值之和大于sum, 那么左边窗口右移一下
            }else{
                plow++;
            }
        }
        return result;
    }
}
