package 剑指offer;
/*
 * 使用分治思想
 * DP比递归快了25倍
 */

public class 矩形覆盖 {
    //递归解法
    public static int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    //动态规划解法
    public static int rectCoverDp(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int tmp1 = 1;   //2*1的矩形，只能竖着放，一种可能
        int tmp2 = 2;   //2*2的矩形，可以两个横着，可以两个竖着，两种可能
        int ans = 0;
        target = target - 2;   //前面tmp1, tmp2已经用掉了2*2的矩形，所以减2
        for(int i = 0; i < target; i++){
            ans = tmp1 + tmp2;
            tmp1 = tmp2;
            tmp2 = ans;
        }
//        while (target-- > 0) {
//            ans = tmp1 + tmp2;
//            tmp1 = tmp2;
//            tmp2 = ans;
//        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println(RectCover(5));
        System.out.println(rectCoverDp(3));
    }
}
