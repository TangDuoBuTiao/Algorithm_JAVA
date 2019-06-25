package leetcode;
/*
 问题描述：给定一个正整数数组A，如果A的某个子数组中不同整数的个数恰好为K，则称A的这个连续、不一定独立的子数组为好子数组。
        （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
         返回 A 中好子数组的数目。
 Eg: 输入：A = [1,2,1,2,3], K = 2
     输出：7
     解释：恰好由2个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 提示：
    1 <= A.length <= 20000
    1 <= A[i] <= A.length
    1 <= K <= A.length
 */

public class num992_K个不同整数的子数组 {
    public static int subarraysWithKDistinct(int[] A, int k) {
        int res = 0;
        int tmp = 1;
        int l = 0;
        int count = 0;
        int[] hash = new int[A.length + 1];
        for (int r = 0; r < A.length; r++) {
            hash[A[r]]++;
            if (hash[A[r]] == 1) {
                count++;
            }
            while (hash[A[l]] > 1 || count > k) {
                if (count > k) {
                    tmp = 1;
                    count--;
                } else {
                    tmp++;
                }
                hash[A[l]]--;
                l++;
            }
            if (count == k) {
                res += tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct(a, 2));
    }
}
