package 数组和矩阵;
/*    《计算数组的小和》
 * 数组小和的定义：数组s = [1,3,5,2,4,6], 在s[0]的左边小于或者等于s[0]的数的和为0;
 * 在s[1]的左边小于等于s[1]的数的和为1，s[2]... 1+3=4   s[3]...1    s[4]... 1+3+2=6  s[5]... 1+3+5+2+4=15
 * 所以s的小和为0+1+4+1+6+15=27
 * 给定一个数组s,实现返回s的小和
 */

public class 计算数组的小和 {
    /*
     * 时间复杂度O(NlogN), 额外空间复杂度为O(N)的方法，利用归并排序
     */
    public static int getSmallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return func(arr, 0, arr.length - 1);

    }

    public static int func(int[] s, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) / 2;

        return func(s, l, mid) + func(s, mid + 1, r) + merge(s, l, mid, r);
    }

    //二路归并，将两个排序好的子序列合并为一个子序列
    public static int merge(int[] s, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        int smallSum = 0;
        while (i <= mid && j <= right) {
            if (s[i] <= s[j]) {
                smallSum += s[i] * (right - j + 1);
                tmp[index++] = s[i++];
            } else {
                tmp[index++] = s[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = s[i++];
        }
        while (j <= right) {
            tmp[index++] = s[j++];
        }
        //把辅助数组的值复制给原数组
        index = 0;
        while (left <= right) {
            s[left++] = tmp[index++];
        }
//        for (; (j < right + 1) || (i < mid + 1); j++, i++) {
//            tmp[index++] = i > mid ? s[j] : s[i];
//        }
//        for (int k = 0; k != tmp.length; k++) {
//            s[left++] = tmp[k];
//        }
        return smallSum;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 4, 6};
        System.out.println(getSmallSum(a));
    }

}
